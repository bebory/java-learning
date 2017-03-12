package practice;
import java.util.Scanner;

import javax.swing.*;
 class dialogBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 
		 Object[] a={ "确定", "取消", "帮助"};
		 Object[] b={ "First", "Second", "Third" };  
		 
		 //第一个对话框
		 JOptionPane.showConfirmDialog(null, "确定保存吗", "温馨提示",JOptionPane.YES_NO_OPTION
				 );
		 
		 //第二个对话框
		 JOptionPane.showMessageDialog(null, "在对话框内显示的描述性的文字", 
				 "标题条文字串",JOptionPane.ERROR_MESSAGE); 
		 
		 //第三个对话框
		 JOptionPane.showOptionDialog(null, "这是一个选项对话框，用户可以选择自己的按钮的个数",
				 "选项对话框标题",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, a, a[0]);
		 
		 //第四个对话框
		 JOptionPane.showInputDialog(null,"Please input a value","输入",JOptionPane.QUESTION_MESSAGE); 
		 
		 //第五个对话框
		 JOptionPane.showInputDialog(null,"Choose one\n", "Input", 
				 JOptionPane.INFORMATION_MESSAGE,null,b, "First");

	}

}
