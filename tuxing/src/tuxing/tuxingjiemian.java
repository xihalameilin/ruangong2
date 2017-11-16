package tuxing;

import javax.swing.*;

import java.awt.*;

public class tuxingjiemian {

	public static void main(String[] args) {
		JFrame log  =  new JFrame();
		log.setBackground(Color.RED);
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenwidth=screenSize.width;
		int screenheight=screenSize.height;
		int frameheight=0;
		int framewidth=0;
		if(screenwidth*3>screenheight*4){
			frameheight=screenheight/2;
			framewidth=screenwidth*3/4;
		}
		else{
			frameheight=screenheight*3/4;
			framewidth=screenwidth/3;
		}
		//System.out.println(framewidth);
		log.setBounds((screenwidth-framewidth)/2,(screenheight-frameheight)/2,framewidth,frameheight);
		log.setTitle("µÇÂ¼");
		log.setVisible(true);
		JPanel blackpanel=new JPanel();
		blackpanel.setBackground(Color.BLACK);
		blackpanel.setBounds(0, 0, framewidth, frameheight*3/5);
		blackpanel.setLayout(null);
		blackpanel.setVisible(true);
		log.add(blackpanel);
		JPanel whitepanel=new JPanel();
		whitepanel.setBackground(Color.white);
		whitepanel.setBounds(0, frameheight*4/5, framewidth, frameheight*2/5);
		whitepanel.setLayout(null);
		whitepanel.setVisible(true);
		log.add(whitepanel);
	}

}
