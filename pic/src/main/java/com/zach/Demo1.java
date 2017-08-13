package com.zach;

import javax.swing.*;
  
/* 
 非容器组件: 
 */  
  
public class Demo1 {  
      
    public static void main(String[] args) {  
        JFrame frame= new JFrame("注册");  
        //创建一个面板
        JPanel panel = new JPanel();
        frame.add(panel);   
        //用户名  
        JLabel nameLabel = new JLabel("用户名");  
        //用户名的输入框  
        JTextField nameField = new JTextField(12);  
        //把用户名的组件添加到面板上  
        panel.add(nameLabel);  
        panel.add(nameField);  
          
        //密码  
        JLabel passLabel= new JLabel("密码");  
        //密码框  
        JPasswordField passField = new JPasswordField(12);  
        //把密码的组件添加到面板  
        panel.add(passLabel);  
        panel.add(passField);  
          
        //性别--单选框  
        JLabel sexLabel = new JLabel("性别");  
        JRadioButton man = new JRadioButton("男",true);  
        JRadioButton woman = new JRadioButton("女");  
        //如果是单选框必须要进行分组，同一个组的单选框只能选择其中的一个  
        ButtonGroup group = new ButtonGroup();  
        group.add(woman);  
        group.add(man);  
        //把性别组件添加到面板上  
        panel.add(sexLabel);  
        panel.add(man);  
        panel.add(woman);  
          
        //来自城市--->下拉框  
        JLabel cityLabel = new JLabel("来自的城市");  
        Object[]  arr = {"北京","上海","广州","深圳","湛江"};  
        JComboBox citys = new JComboBox(arr);  
        panel.add(cityLabel);  
        panel.add(citys);  
          
        //兴趣爱好---->复选框  
        JLabel hobitLabel = new JLabel("兴趣爱好:");  
        JCheckBox checkBox1 = new JCheckBox("篮球",true);  
        JCheckBox checkBox2 = new JCheckBox("java",true);  
        JCheckBox checkBox3 = new JCheckBox("javascript");  
        JCheckBox checkBox4 = new JCheckBox("android");  
        panel.add(hobitLabel);  
        panel.add(checkBox1);  
        panel.add(checkBox2);  
        panel.add(checkBox3);  
        panel.add(checkBox4);  
          
          
        //个人简介  
        JLabel jLabel = new JLabel("个人简介");  
        JTextArea area = new JTextArea(20, 15);  
        area.setLineWrap(true); //设置自动换行   
        panel.add(jLabel);  
        panel.add(area);


    }
}