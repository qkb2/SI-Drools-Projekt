package com.sample;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class KidPhones {
	
	public static final void main(String[] args) {
		
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");
        	
        	AppGUI appUI = new AppGUI();
        	kSession.setGlobal("appGUI", appUI);
        	
            kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
	
	public static class AppGUI extends JFrame {

		/**
		 * App GUI container.
		 */
		private static final long serialVersionUID = 1L;
		private static JPanel panel;
		private static JLabel question;
		private static JButton nextButton;
		private static ButtonGroup optionsRBG;
		
		AppGUI() {
			panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			add(panel);
			setSize(800, 600);
			setVisible(true);
		}
		
		static void updateGUI() {
			
		}
	}
	
}
