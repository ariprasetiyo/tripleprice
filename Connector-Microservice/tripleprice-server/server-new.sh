#!/bin/bash
WORKING_DIR=$(pwd)
DEBUG_PORT=4002
SERVER_PORT=8080
JMX_PORT=9012
RMI_PORT=9022

JVM_ARGS="$JVM_ARGS -server -Xms128M -Xmx1024M "
#JVM_ARGS="$JVM_ARGS -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.ssl=false"
#JVM_ARGS="$JVM_ARGS -Dcom.sun.management.jmxremote.authenticate=true"
#JVM_ARGS="$JVM_ARGS -Dcom.sun.management.jmxremote.password.file=$HOME/config/jmxremote.password"
#JVM_ARGS="$JVM_ARGS -Dcom.sun.management.jmxremote.access.file=$HOME/config/jmxremote.access"
#JVM_ARGS="$JVM_ARGS -Djava.rmi.server.hostname=$LISTEN_IP"
#JVM_ARGS="$JVM_ARGS -Dcom.sun.management.jmxremote.rmi.port=$RMI_PORT"
#JVM_ARGS="$JVM_ARGS -Dcom.sun.management.jmxremote.port=$JMX_PORT"
JVM_ARGS="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=$DEBUG_PORT"

chmod -R 777 nohup.out
rm nohup.out 
do_stop(){
	cd ${WORKING_DIR}
	fuser -k $SERVER_PORT/tcp
	echo "KILL port $SERVER_PORT"
	return 0
}
do_start(){
	cd ${WORKING_DIR}
	# mvn clean package spring-boot:run -DskipTests exec:exec -Dexec.executable="java" -Dexec.args="-classpath %classpath -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=$DEBUG_PORT"
	nohup java -jar tripleprice-runner-*.jar -Drun.jvmArguments="$JVM_ARGS" &
	# mvn clean install exec:exec
	# nohup mvn spring-boot:run -DskipTests exec:exec -Dexec.executable="java" -Dexec.args="-classpath %classpath $JVM_ARGS" &
	return 0
}
do_move(){
	cd ${WORKING_DIR}
	cp -R ../tripleprice-runner/src/main/resources .
	cp -R ../tripleprice-runner/src/main/webapp ${WORKING_DIR}/src/main/
	cp ../tripleprice-runner/target/tripleprice-runner-*.jar .
	return 0
}
do_clean_install(){
	cd ${WORKING_DIR}
	cd ../
	echo $pwd
	mvn clean install
	return 0	
}

case "$1" in
	move)
		do_move
		;;
	clean)
		do_stop
		do_clean_install
		;;
	start)
		do_stop
		do_start
		;;
	stop)
		do_stop
		;;
	restart)
		do_stop
		do_clean_install
		do_move
		do_start
		;;
	*)
		echo "Usage: ./server.sh clean|start|stop|restart"
		;;
esac
cd ${WORKING_DIR}
chmod -R 777 -R ../tripleprice-server
cd ${WORKING_DIR}
tail -f nohup.out
exit 0