package com.hiersun.xzkp.service;

import java.util.Map;

/**
 * 短信服务层
 * @author liuyang
 * @email y_liu@hiersun.com | 745089707@qq.com
 */
public interface SmsService {

	/**
	 * 发送短信
	 * @param mobile 手机号
	 * @param content 发送内容
	 * @param appName 应用名称
	 * @param businessScene 业务场景
	 * @return
	 */
	public boolean send(String mobile, String content, String appName, String businessScene);

	/**
	 * 发送短信
	 * @param mobile 手机号
	 * @param content 发送内容
	 * @param appName 应用名称
	 * @param businessScene 业务场景
	 * @param terminal 发送终端
	 * @return
	 */
	public boolean send(String mobile, String content, String appName, String businessScene, String terminal);

	/**
	 * 群发送短信
	 * @param mobiles 手机号数组
	 * @param content 发送内容
	 * @param appName 应用名称
	 * @param businessScene 业务场景
	 * @param terminal 发送终端
	 * @return 返回Map，key代表手机号，value代表是否发送成功
	 */
	public Map<String, Boolean> send(String[] mobiles, String content, String appName, String businessScene,
			String terminal);
}
