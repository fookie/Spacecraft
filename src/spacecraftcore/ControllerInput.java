package spacecraftcore;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import de.hardcode.jxinput.Button;
import de.hardcode.jxinput.JXInputDevice;
import de.hardcode.jxinput.JXInputManager;
import de.hardcode.jxinput.keyboard.JXKeyboardInputDevice;
import de.hardcode.jxinput.virtual.JXVirtualInputDevice;

public class ControllerInput implements ActionListener {
	private JXKeyboardInputDevice   mKeyboardDevice = null;
	private JXVirtualInputDevice    mVirtualDevice  = null;
	private JXInputDevice ji=JXInputManager.getJXInputDevice( 1);
	Button m_up;//m:move 
	Button m_down;
	Button m_left;
	Button m_right;
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JXInputManager.updateFeatures();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
			//TODO 应该在这里和咱们的程序衔接
			}
		});
	}

	
}
