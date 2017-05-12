package com.xxxx.common;

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
	 * @param terminal 发送终端
	 * @return
	 */
	public boolean send(String mobile, String content, String appName, String businessScene, String terminal);
}
