package window;

// Dillon C. Strickland
// 3/27/2025
// A window class, which can resize and close/open a GUI window, easily.
public class TestWindow {

    public static void main(String[] args) {
        GUIComponent w1 = new Window(1, 1);
        if (w1.open()) {
            w1.move(10,10);
            w1.resize(30, 20);
            w1.close();
        }
    }

    public interface GUIComponent {
        boolean open();
        boolean close();
        void move(int a, int b);
        void resize(int a, int b);
    }

    public static class Window implements GUIComponent {
        private int width;
        private int height;
        private int xPos;
        private int yPos;

        public Window(int width, int height) {
            this.width = width;
            this.height = height;
            this.xPos = -1;
            this.yPos = -1;
        }

        public int getHeight() {
            return height;
        }

        public int getWidth() {
            return width;
        }

        public int getXPos() {
            return xPos;
        }

        public int getYPos() {
            return yPos;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public void setXPos(int xPos) {
            this.xPos = xPos;
        }

        public void setYPos(int yPos) {
            this.yPos = yPos;
        }

        @Override
        public boolean open() {
            System.out.println("Window opened");
            return true;
        }

        @Override
        public boolean close() {
            System.out.println("Window closed");
            return true;
        }

        @Override
        public void resize(int width, int height) {
            setWidth(width);
            setHeight(height);
            System.out.println("Window resized to " + width + "x" + height);
        }

        @Override
        public void move(int x, int y) {
            setXPos(x);
            setYPos(y);
            System.out.println("Window moved to " + x + "x" + y);
        }
    }
}