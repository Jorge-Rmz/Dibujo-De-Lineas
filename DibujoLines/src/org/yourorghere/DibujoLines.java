package org.yourorghere;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class DibujoLines extends JFrame {

    static GL gl;
    static GLU glu;

    public DibujoLines() {
        setTitle("Dibujo de lineas");
        //Instanciamos la clase Graphic
        GraphicListener listener = new GraphicListener();
        //Creamos el canvas
        GLCanvas canvas = new GLCanvas(new GLCapabilities());
        canvas.addGLEventListener(listener);
        getContentPane().add(canvas);
    }

    public static void main(String args[]) {
        DibujoLines ventana = new DibujoLines();

        ventana.setResizable(false);
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventana.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public class GraphicListener implements GLEventListener {

        public void display(GLAutoDrawable arg0) {
            // Indicamos el tamaño en pixeles del grosor de la linea
            gl.glLineWidth(4);
           
            for (int i = 0; i < 351; i = i + 24) {
                int x = 352, y = 350, x1 = 1023, y1 = 400;
                //Indicamos que vamos a iniciar a crear lineas
                gl.glBegin(GL.GL_LINES);
                gl.glColor3f(1, 0, 1);

                gl.glVertex2d(x - i, y - i);
                gl.glVertex2d(x1 + i, y - i);

                gl.glVertex2d(x - i, y - i);
                gl.glVertex2d(x - i, y1 + i);

                gl.glVertex2d(x - i, y1 + i);
                gl.glVertex2d(x1 + i, y1 + i);

                gl.glVertex2d(x1 + i, y - i);
                gl.glVertex2d(x1 + i, y1 + i);

                gl.glEnd();

            }
            gl.glFlush();

        }

        public void init(GLAutoDrawable arg0) {
            glu = new GLU();
            gl = arg0.getGL();
            gl.glClearColor(0, 0, 0, 0);
            //Establecer los parametros para la proyeccion
            gl.glMatrixMode(gl.GL_PROJECTION);

            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            double width = screenSize.getWidth();
            double height = screenSize.getHeight();

            glu.gluOrtho2D(0, width, 0, height);

        }

        public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {

        }

        public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {

        }

    }
}
