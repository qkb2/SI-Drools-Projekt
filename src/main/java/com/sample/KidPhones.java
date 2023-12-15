package com.sample;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
		 * GUI JFrame container with update method.
		 */
		private static final long serialVersionUID = 1L;
		private Integer counter;
		private String userAnswer;
		
		public String getUserAnswer() { return this.userAnswer; }
		
		AppGUI() { counter = 0; }
		
		public void updateGUI(String question, String[] options, boolean isEnd) {
			if (!isEnd) {
				counter++;
				int nOption = JOptionPane.showOptionDialog(
						this, question, "Question " + counter.toString(), 
						JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, 
						null, options, options[0]);
				if (nOption == -1) System.exit(0);
				userAnswer = options[nOption];
			} else {
				JOptionPane.showMessageDialog(this, question, "Result", JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			}
		}
	}
	
}
