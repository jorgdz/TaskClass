package ec.edu.espol.util;

/**
 *
 * @author Francisco Mayancela
 */
public class Vector {
    private double x;
    private double y;

    public Vector(double x) {
       this.x = x;
       this.y = 0;
    }

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    public Vector sumar(Vector v1, Vector v2) {
        double coordX = v1.getX() + v2.getX();
        double coordY = v1.getY() + v2.getY();
        return new Vector(coordX, coordY);  
    }
    
    public Vector restar(Vector v1, Vector v2) {
        double x = v1.getX() - v2.getX();
        double y = v1.getY() - v2.getY();
        return new Vector(x, y);  
    }
    
    public double modulo ()
    {
        double tmp = Math.pow(x, 2) + Math.pow(y, 2);
        return Math.sqrt(tmp);
    }
    
    public Vector vectorUnitario ()
    {
        double vX = this.x / this.modulo();
        double vY = this.y / this.modulo();
        return new Vector(vX, vY);
    }

    @Override
    public String toString() {
        return "V=("+ x + ", " + y + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vector other = (Vector) obj;
        if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
        if (Double.doubleToLongBits(this.y) != Double.doubleToLongBits(other.y)) {
            return false;
        }
        return true;
    }
    
}
