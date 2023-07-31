package com.yanzhuang.controller;

import com.yanzhuang.http.HttpComponentUtil;
import com.yanzhuang.http.HttpTest;
import com.yanzhuang.po.AccessToken;
import com.yanzhuang.po.Login;
import com.yanzhuang.po.LoginVO;
import com.yanzhuang.service.LoginService;
import com.yanzhuang.util.AccountPoolManager;
import com.yanzhuang.util.RSAEncrypt;
import com.yanzhuang.util.RSAUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class LoginController {
	private AccountPoolManager apm=new AccountPoolManager();
	boolean token=false;
	RSAEncrypt rsaEncrypt=new RSAEncrypt();
	@Resource
	private LoginService lsi; //= new LoginServiceImpl();
	@Autowired
	private StringRedisTemplate stringRedisTemplate;


	@RequestMapping("/getpublickey.do")
	@ResponseBody
	public Map<String, String> getPublicKey(HttpServletRequest request) throws Exception {
		RSAEncrypt.genKeyPair();
		Map<Integer, String> keyMap = RSAEncrypt.getKeyMap();
		String publicKey = keyMap.get(0);
		String privateKey = keyMap.get(1);

		// Store the private key in Redis
		String sessionId = request.getSession().getId();
		stringRedisTemplate.opsForValue().set(sessionId + "_privateKey", privateKey);

		// Respond with the public key and sessionId
		Map<String, String> response = new HashMap<>();
		response.put("publicKey", publicKey);
		response.put("sessionId", sessionId);
		return response;
	}


	@RequestMapping("/login.do")
	@ResponseBody
	public LoginVO Login(String stuid, String encryptedPwd, String encryptedDesKey,String sessionId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Decode the incoming data
		encryptedPwd = encryptedPwd.replaceAll("%2B", "+");
		encryptedDesKey = encryptedDesKey.replaceAll("%2B", "+");

		// Retrieve the private key from Redis
		String privateKey = stringRedisTemplate.opsForValue().get(sessionId + "_privateKey");

		// Decrypt the DES key and password
		String desKey = RSAEncrypt.decrypt(encryptedDesKey, privateKey);
		String encrypted2 = RSAUtils.encryptWithDES("123",desKey);
		System.out.println("后端使用同样的des密钥加密后的密文："+encrypted2);
		System.out.println("两个加密后密码一样"+encrypted2.equals(encryptedPwd));
		// Decrypt the password with decrypted DES key
		String decryptedPwd = RSAUtils.decryptWithDES(encryptedPwd, desKey);
		System.out.println(decryptedPwd);

		LoginVO loginVo = lsi.login(stuid, decryptedPwd);
		Login log = loginVo.getLog();
		HttpSession session = request.getSession();
		session.setAttribute("log", log);
		return loginVo;
	}


	@RequestMapping("/getbutton.do")
	@ResponseBody
	public List<Object> getButton() {

		return  lsi.getallButtons();
	}

	@RequestMapping("/getbutton2.do")
	@ResponseBody
	public void getButton2(String menujson) {
		String url="https://api.weixin.qq.com/cgi-bin/token?grant_type" +
				"=client_credential&appid=wxf69722644f6d60e9&secret=fadcc3f7f35049148e31403f28c8a822";
		String url2="https://api.weixin.qq.com/cgi-bin/menu/create?access_token=";
		String json= HttpTest.get(url);
		menujson="{\"button\":"+menujson+"}";
		System.out.println(menujson);
		JSONObject jsonObject=JSONObject.fromObject(json);
		AccessToken accessToken=(AccessToken) JSONObject.toBean(jsonObject,AccessToken.class);
		System.out.println(accessToken.getAccess_token());
		String url3=url2+accessToken.getAccess_token();
		System.out.println(url3);
		System.out.println(HttpComponentUtil.doPostByJson(url3,menujson));

	}

	@RequestMapping("/getallweixinmenu.do")
	@ResponseBody
	public List<Object> getMenu() {
		List<Object> lists=lsi.getMenu();
		System.out.println(lists);
		return  lists;
	}


	@RequestMapping("/getpwd.do")
	@ResponseBody
	public String sendPwd(String pwd) throws Exception {
		pwd = pwd.replaceAll("%2B","+");
		String privateKey = RSAEncrypt.getKeyMap().get(1);
		System.out.println("Private key: " + privateKey);
		pwd = RSAUtils.decryptBase64(pwd);
		System.out.println("Decrypted password: " + pwd);
		return "Decryption completed";
	}

}
