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
      final GL2 gl2 = drawable.getGL().getGL2();
      final GL2 gl3 = drawable.getGL().getGL2();
      final GL2 gl4 = drawable.getGL().getGL2();
//final GL2 gl = drawable.getGL().getGL2();
//		LINHA EXEMPLO      
//      gl.glBegin (GL2.GL_LINES);//static field
//      gl.glVertex3f(0.50f,-0.50f,0);
//      gl.glVertex3f(-0.50f,0.50f,0);
//      gl.glEnd();
      
//	  TRIANGULO EXEMPLO
//      gl.glBegin(GL2.GL_TRIANGLES);
//      gl.glVertex2f(1.0f,0);
//      gl.glVertex2f(0,0);
//      gl.glVertex2f(0,1.0f);
//      gl.glEnd();		
//   }
  // LEMBRAR -> glVertex2f(x,y) partindo sempre do 0 (centro)
   
 //	QUADRADO BASE - COLORIDO EM OPENGL
   gl2.glBegin(GL2.GL_QUADS);
   gl2.glColor3f(0f,0f,0.8f); // Setando Azul
   gl2.glVertex2f(0.5f, -0.5f); // Setando Lado 01
   gl2.glVertex2f(0.5f, 0.5f); // Setando Lado 02
   gl2.glVertex2f(-0.5f, 0.5f); // Setando Lado 03
   gl2.glVertex2f(-0.5f, -0.5f); // Setando Lado 04
   gl2.glEnd();

 //	  TRIANGULO DO TETO - COLORIDO EM OPENGL
   gl.glBegin(GL2.GL_TRIANGLES);
   gl.glColor3f(0.8f,  0f,  0f);   //nos da vermelho          
   gl.glVertex2f(0f,1f); // Lado 01           
   gl.glVertex2f(0.61f,0.51f);	// Lado 02  
   gl.glVertex2f(-0.61f,0.51f); //Lado 03
   gl.glEnd();
   
   //	QUADRADO DA PORTA - COLORIDO EM OPENGL
   gl3.glBegin(GL2.GL_QUADS);
   gl3.glColor3f(0f,0.8f,0f); // Setando Verde
   gl3.glVertex2f(0f, -0.45f); // Setando Lado 01
   gl3.glVertex2f(0.2f, -0.45f); // Setando Lado 02
   gl3.glVertex2f(0.2f, 0.2f); // Setando Lado 04
   gl3.glVertex2f(0f, 0.2f); // Setando Lado 03
   gl3.glEnd();
   
   //	QUADRADO DA JANELA - COLORIDO EM OPENGL
   gl4.glBegin(GL2.GL_QUADS);
   gl4.glColor3f(1f,1f,0f); // Setando Verde
   gl4.glVertex2f(-0.2f, 0.45f); // Setando Lado 01
   gl4.glVertex2f(-0.4f, 0.45f); // Setando Lado 02
   gl4.glVertex2f(-0.4f, 0.2f); // Setando Lado 04
   gl4.glVertex2f(-0.2f, 0.2f); // Setando Lado 03
   gl4.glEnd();
   
   
   } // FIM 
   
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
      
   
      //creating first frame
      final JFrame frame = new JFrame ("Casa Colorida");
   
      //adding canvas to frame
      frame.getContentPane().add(glcanvas);
      frame.setSize(frame.getContentPane().getPreferredSize());
      frame.setVisible(true);
      
   }//end of main

@Override
public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
	
}
	
}//end of classimport javax.media.opengl.GL2;