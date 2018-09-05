/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.triple.dao;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import my.triple.model.AuthorizationModel;

/**
 *
 * @author ari-prasetiyo
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorizationTest {

	static Logger log = LoggerFactory.getLogger(AuthorizationTest.class);
	@Autowired
	AuthorizationDao dsSysAuthorization;

	// @Test
	public void getAuthorizationById() {
		AuthorizationModel authorizationModel = new AuthorizationModel();
		authorizationModel.setId(132L);
		dsSysAuthorization.findById(authorizationModel.getId());
		// log.debug("test--" + result.getSysMenu().getMenusName());
		/* Assert.assertNotNull(result.getSysMenu().getMenusName()); */
	}
}
