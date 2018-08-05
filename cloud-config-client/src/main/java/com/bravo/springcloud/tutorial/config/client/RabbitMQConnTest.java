package com.bravo.springcloud.tutorial.config.client;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 测试MQ是否能连通
 * @author Bobby
 *
 */
public class RabbitMQConnTest {

	public static void main(String[] args) {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		factory.setPort(5672);
		factory.setUsername("Bobby"); 
		factory.setPassword("111111");
		
		try (Connection conn = factory.newConnection()){
			Channel ch = conn.createChannel();
			
			ch.close();
			System.out.println("Connected success!");
		} catch (IOException | TimeoutException e) {
			e.printStackTrace();
		}
	}
/*
 * RabbitMQ的一些常用操作
 * 
 * 已添加用户Bobby，密码111111，并且已设置为超级管理员
 * .\rabbitmqctl.bat add_user Bobby 111111
 * .\rabbitmqctl.bat set_user_tags Bobby administrator
 * .\rabbitmqctl.bat set_permissions -p / Bobby ".*" ".*" ".*"  （一定不能少，否则没有远程登录的权限，即外部程序无法连接）
 * 
 * 修改密码命令：
 * .\rabbitmqctl.bat change_password <username> <newPassword>
 * 
 * 删除用户：
 * .\rabbitmqctl.bat delete_user <username>
 * 
 * 访问控制台：
 * http://localhost:15672/
 * 
 * 默认连接端口：5672
 */
}
