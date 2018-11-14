package tripleprice.concurrent.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource(locations = "file:resources/application.properties")
public class CallableAndFutureAndExecutorServiceTest {

	@Autowired
	@Qualifier("bossExecutorService")
	ExecutorService executorService;

	@Test
	public void concurrentTheardRunnableTest() throws InterruptedException, ExecutionException {

		long startTime = System.currentTimeMillis();
		final List<CompletableFuture<Integer>> list = new ArrayList<CompletableFuture<Integer>>();
		for (int a = 0; a < 10; a++) {
			final int variableA = a;
			final CompletableFuture<Integer> completableFuture = new CompletableFuture<>();
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						if (variableA == 5) {
							Thread.sleep(3000);
						} else {
							Thread.sleep(1000);
						}
						System.out.println(variableA);
						completableFuture.complete(variableA);
						final long finishTime = System.currentTimeMillis() - startTime;
						System.out.println("Xxxx1 : "+finishTime);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
			list.add(completableFuture);
		}
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("--------------");
		for (CompletableFuture<Integer> sas : list) {
			System.out.println(sas.get());
		}
		System.out.println("Finish");
	}

	@Test
	public void concurrentCompletableTest() throws InterruptedException, ExecutionException {

		long startTime = System.currentTimeMillis();
		final List<CompletableFuture<Integer>> list = new ArrayList<CompletableFuture<Integer>>();
		for (int a = 0; a < 10; a++) {
			final int variableA = a;
			final CompletableFuture<Integer> completableFuture = new CompletableFuture<>();
			final Runnable task = new Runnable() {
				@Override
				public void run() {
					try {
						if (variableA == 5) {
							Thread.sleep(3000);
						} else {
							Thread.sleep(1000);
						}
						System.out.println(variableA);
						completableFuture.complete(variableA);
						final long finishTime = System.currentTimeMillis() - startTime;
						System.out.println("Xxxx2 : "+finishTime);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			executorService.submit(task);
			list.add(completableFuture);
		}
		
		System.out.println("xxxxx");
		for (CompletableFuture<Integer> sas : list) {
			System.out.println("-" + sas.get());
		}
		System.out.println("Finish");
	}

	@Test
	public void concurrentFutureTest() throws InterruptedException, ExecutionException {

		final long startTime = System.currentTimeMillis();
		final List<Future<Integer>> list = new ArrayList<Future<Integer>>();
		for (int a = 0; a < 10; a++) {
			final int variableA = a;
			final CompletableFuture<Integer> completableFuture = new CompletableFuture<>();
			final Runnable task = new Runnable() {
				@Override
				public void run() {
					try {
						if (variableA == 5) {
							Thread.sleep(3000);
						} else {
							Thread.sleep(1000);
						}
						System.out.println(variableA);
						completableFuture.complete(variableA);
						final long finishTime = System.currentTimeMillis() - startTime;
						System.out.println("Xxxx3 : "+finishTime);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			executorService.submit(task);
			list.add(completableFuture);
		}

		for (Future<Integer> sas : list) {
			System.out.println("-" + sas.get());
		}
		System.out.println("Finish");
	}

	@Test
	public void concurrentCallableTest() throws InterruptedException, ExecutionException {
		
		final long startTime = System.currentTimeMillis();
		final List<Future<Integer>> list = new ArrayList<Future<Integer>>();
		for (int a = 0; a < 10; a++) {
			final int variableA = a;
			final Callable<Integer> task = new Callable<Integer>() {

				@Override
				public Integer call() throws Exception {
					try {
						if (variableA == 5) {
							Thread.sleep(3000);
						} else {
							Thread.sleep(1000);
						}
						System.out.println(variableA);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					final long finishTime = System.currentTimeMillis() - startTime;
					System.out.println("Xxxx4 : "+finishTime);
					return variableA;
				}
			};
			Future<Integer> future = executorService.submit(task);
			list.add(future);
		}
		
		for (Future<Integer> sas : list) {
			System.out.println("-" + sas.get());
		}
		System.out.println("Finish");
	}
}
