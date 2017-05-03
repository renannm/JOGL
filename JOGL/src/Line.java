import javax.swing.JFrame;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;

public  class Line implements GLEventListener {
	
   @Override
   public void display(GLAutoDrawable drawable) {
      final GL2 gl = drawable.getGL().getGL2();
            
//      gl.glBegin (GL2.GL_LINES);//static field
//      gl.glVertex3f(0.50f,-0.50f,0);
//      gl.glVertex3f(-0.50f,0.50f,0);
//      gl.glEnd();
//		TRIANGULO EXEMPLO
      gl.glBegin(GL2.GL_TRIANGLES);
      gl.glVertex2f(1.0f,0);
      gl.glVertex2f(0,0);
      gl.glVertex2f(0,1.0f);
      gl.glEnd();		
   }
            
   @Override
   public void dispose(GLAutoDrawable arg0) {
      //method body
   }
            
   @Override
   public void init(GLAutoDrawable arg0) {
      // method body
   }
   
	
   public static void main(String[] args) {

      //getting the capabilities object of GL2 profile        
      final GLProfile profile = GLProfile.get(GLProfile.GL2);
      GLCapabilities capabilities = new GLCapabilities(profile);
   
      // The canvas
      final GLCanvas glcanvas = new GLCanvas(capabilities);
      Line line = new Line();
      glcanvas.addGLEventListener(line);
      glcanvas.setSize(400, 400);
   
      //creating frame
      final JFrame frame = new JFrame ("straight Line");
   
      //adding canvas to frame
      frame.getContentPane().add(glcanvas);
      frame.setSize(frame.getContentPane().getPreferredSize());
      frame.setVisible(true);
      
   }//end of main

@Override
public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
	
}
	
}//end of classimport javax.media.opengl.GL2;
