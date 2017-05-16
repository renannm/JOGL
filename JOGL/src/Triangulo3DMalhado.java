import javax.swing.JFrame;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;

public class Triangulo3DMalhado implements GLEventListener {

	private GLU glu = new GLU();
	   private float rtri = 0.0f; 
	 public float h = 1 ;
		
	   @Override
	   public void display( GLAutoDrawable drawable ) {
		      final GL2 gl = drawable.getGL().getGL2(); //Objeto Triângulo
		      final GL2 gl2 = drawable.getGL().getGL2(); //Malha de linhas 01
		      final GL2 gl3 = drawable.getGL().getGL2(); //Malha de linhas 01
		   
		      gl.glMatrixMode( GL2.GL_PROJECTION );
		      gl.glLoadIdentity();
				
		      glu.gluPerspective( 45.0f, h, 1.0, 40.0 );
		      glu.gluLookAt(Math.cos(rtri) * 6, 2, Math.sin(rtri) * 6, 0, 0, 0, 0, 1, 0);
		      gl.glMatrixMode( GL2.GL_MODELVIEW );
		      gl.glLoadIdentity();
		

			
	      gl.glShadeModel( GL2.GL_SMOOTH );
	      gl.glClearColor( 0f, 0f, 0f, 0f );
	      gl.glClearDepth( 1.0f );
	      gl.glEnable( GL2.GL_DEPTH_TEST );
	      gl.glDepthFunc( GL2.GL_LEQUAL );
	      gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);

	      // Clear The Screen And The Depth Buffer
	      gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT); 
	      gl.glLoadIdentity(); // Reset The View

	      //gl.glRotatef( rtri, 0.0f, 1.0f, 0.0f );
	     // gl.glRotatef( -rtri, 1.0f, 1.0f, 0.0f );
	      
	   // CRIANDO O CHÃO COM MALHA DE LINHAS TRACEJADAS 
	      
	      //MALHA 01
	      
	      // Definindo o eixo Z como o escolhido.
	      // A amplitude do eixo Z é de -10 até 10 (20 casas)
	      // Y é sempre -1 (altura o chão)
	      // O eixo X é definidp como uma linha que repete 20 vezes (de -10 á 10)
	      
	      gl2.glBegin (GL2.GL_LINES);
	      float z = -10f;
	      while(z != 10.0f){
	    	  gl.glColor3f(1f, 1f, 1f); //Definindo a cor Branca
		      gl.glVertex3f(-10f,-1,z);
		      gl.glVertex3f(10f,-1,z);
		      z += 0.25f;
	      }
	      gl2.glEnd();
	      gl2.glFlush();
	      
	      //MALHA 02
	      
	      // Definindo o eixo X como o escolhido.
	      // A amplitude do eixo X é de -10 até 10 (20 casas)
	      // Y é sempre -1 (altura o chão)
	      // O eixo Z é definidp como uma linha que repete 20 vezes (de -10 á 10)
	      
	      gl3.glBegin (GL2.GL_LINES);
	      float x = -10f;
	      while(x != 10.0f){
	    	  gl.glColor3f(1f, 1f, 1f); //Definindo a cor Branca
		      gl.glVertex3f(x,-1,-10f);
		      gl.glVertex3f(x,-1,10f);
		      x += 0.25f;
	      }
	      gl3.glEnd();
	      gl3.glFlush();
	      
	      //Desenhando os Triangulos
	      gl.glBegin( GL2.GL_TRIANGLES ); 
	      

	      //drawing triangle in all dimensions
	      //front
	      gl.glColor3f( 1.0f, 0.0f, 0.0f ); // Red
	      gl.glVertex3f( 1.0f, 2.0f, 0.0f ); // Top
			
	      gl.glColor3f( 0.0f, 1.0f, 0.0f ); // Green
	      gl.glVertex3f( -1.0f, -1.0f, 1.0f ); // Left
			
	      gl.glColor3f( 0.0f, 0.0f, 1.0f ); // Blue
	      gl.glVertex3f( 1.0f, -1.0f, 1.0f ); // Right)

	      //right
	      gl.glColor3f( 1.0f, 0.0f, 0.0f );
	      gl.glVertex3f( 1.0f, 2.0f, 0.0f ); // Top
			
	      gl.glColor3f( 0.0f, 0.0f, 1.0f );
	      gl.glVertex3f( 1.0f, -1.0f, 1.0f ); // Left
			
	      gl.glColor3f( 0.0f, 1.0f, 0.0f );
	      gl.glVertex3f( 1.0f, -1.0f, -1.0f ); // Right

	      //left
	      gl.glColor3f( 1.0f, 0.0f, 0.0f );
	      gl.glVertex3f( 1.0f, 2.0f, 0.0f ); // Top
			
	      gl.glColor3f( 0.0f, 1.0f, 0.0f );
	      gl.glVertex3f( 1.0f, -1.0f, -1.0f ); // Left 
			
	      gl.glColor3f( 0.0f, 0.0f, 1.0f );
	      gl.glVertex3f( -1.0f, -1.0f, -1.0f ); // Right 

	      //top
	      gl.glColor3f( 0.0f, 1.0f, 0.0f );
	      gl.glVertex3f( 1.0f, 2.0f, 0.0f ); // Top
			
	      gl.glColor3f( 0.0f, 0.0f, 1.0f );
	      gl.glVertex3f( -1.0f, -1.0f, -1.0f ); // Left
			
	      gl.glColor3f( 0.0f, 1.0f, 0.0f );
	      gl.glVertex3f( -1.0f, -1.0f, 1.0f ); // Right
			
	      gl.glEnd(); // Done Drawing 3d triangle (Pyramid)
	      
	      gl.glFlush();
	      
	      rtri += 0.001f;
	   }
	      
	   @Override
	   public void dispose( GLAutoDrawable drawable ) {
	   }
	   
	   @Override
	   public void init( GLAutoDrawable drawable ) {
		
	      final GL2 gl = drawable.getGL().getGL2();
			
	      gl.glShadeModel( GL2.GL_SMOOTH );
	      gl.glClearColor( 0f, 0f, 0f, 0f );
	      gl.glClearDepth( 1.0f );
	      gl.glEnable( GL2.GL_DEPTH_TEST );
	      gl.glDepthFunc( GL2.GL_LEQUAL );
	      gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST );
	   }
	   
	   @Override
	   public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height ) {
		
	      // TODO Auto-generated method stub
	      final GL2 gl = drawable.getGL().getGL2();
	      if( height <= 0 ) 
	         height = 1;
				
	       h = ( float ) width / ( float ) height;
	      gl.glViewport( 0, 0, width, height );
	      gl.glMatrixMode( GL2.GL_PROJECTION );
	      gl.glLoadIdentity();
			
	      glu.gluPerspective( 45.0f, h, 1.0, 40.0 );
	      glu.gluLookAt(0, 0, 10 + rtri, 0, 0, 0, 0, 1, 0);
	      gl.glMatrixMode( GL2.GL_MODELVIEW );
	      gl.glLoadIdentity();
	      
	      
	   }
	      
	   public static void main( String[] args ) {
		
	      // TODO Auto-generated method stub
	      final GLProfile profile = GLProfile.get( GLProfile.GL2 );
	      GLCapabilities capabilities = new GLCapabilities( profile );
			
	      // The canvas
	      final GLCanvas glcanvas = new GLCanvas( capabilities );
	      Triangulo3DMalhado triangledepthtest = new Triangulo3DMalhado();
			
	      glcanvas.addGLEventListener( triangledepthtest );
	      glcanvas.setSize( 400, 400 );
			
	      final JFrame frame = new JFrame ( "Triangulo 3D Professor" );
	      frame.getContentPane().add(glcanvas);
	      frame.setSize( frame.getContentPane().getPreferredSize() );
	      frame.setVisible( true );
	      final FPSAnimator animator = new FPSAnimator( glcanvas, 300, true);
			
	      animator.start();
	   }
	
}
