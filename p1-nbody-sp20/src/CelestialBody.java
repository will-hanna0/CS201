

/**
 * Celestial Body class for NBody
 * @author Will Hanna
 *
 */
public class CelestialBody {

	private double myXPos;
	private double myYPos;
	private double myXVel;
	private double myYVel;
	private double myMass;
	private String myFileName;

	/**
	 * Create a Body from parameters	
	 * @param xp initial x position
	 * @param yp initial y position
	 * @param xv initial x velocity
	 * @param yv initial y velocity
	 * @param mass of object
	 * @param filename of image for object animation
	 */
	public CelestialBody(double xp, double yp, double xv,
			             double yv, double mass, String filename){
		myXPos = xp;
		myYPos = yp;
		myXVel = xv;
		myYVel = yv;
		myMass = mass;
		myFileName = filename;
		// TODO: complete constructor
	}

	/**
	 * Copy constructor: copy instance variables from one
	 * body to this body
	 * @param b used to initialize this body
	 */
	public CelestialBody(CelestialBody b){
		myXPos = b.getX();
		myYPos = b.getY();
		myXVel = b.getXVel();
		myYVel = b.getYVel();
		myMass = b.getMass();
		myFileName = b.getName();
		// TODO: complete constructor
	}

	public double getX() {
		return myXPos;
		// TODO: complete method
	}
	public double getY() {
		// TODO: complete method
		return myYPos;
	}
	public double getXVel() {
		return myXVel;
	}
	/**
	 * Return y-velocity of this Body.
	 * @return value of y-velocity.
	 */
	public double getYVel() {
		// TODO: complete method
		return myYVel;
	}
	
	public double getMass() {
		// TODO: complete method
		return myMass;
	}
	public String getName() {
		// TODO: complete method
		return myFileName;
	}

	/**
	 * Return the distance between this body and another
	 * @param b the other body to which distance is calculated
	 * @return distance between this body and b
	 */
	public double calcDistance(CelestialBody b) {
		double dAnswer = 0;
		double squaredAnswer = 0;
		squaredAnswer = (((b.getX() - myXPos))*(b.getX() - myXPos)) + ((b.getY() - myYPos) * (b.getY() - myYPos));
		dAnswer = Math.sqrt(squaredAnswer);
		// TODO: complete method
		return dAnswer;
	}

	public double calcForceExertedBy(CelestialBody b) {
		final double G = 6.67e-11;
		double forceExerted = 0;
		forceExerted = G * ((myMass * b.getMass()) / (calcDistance(b) * calcDistance(b)));
		// TODO: complete method
		return forceExerted;
	}

	public double calcForceExertedByX(CelestialBody b) {
		double forceX = calcForceExertedBy(b) * ((b.getX() - myXPos) / calcDistance(b));
		// TODO: complete method
		return forceX;
	}
	public double calcForceExertedByY(CelestialBody b) {
		double forceY = ((b.getY() - myYPos) / calcDistance(b)) * calcForceExertedBy(b);
		return forceY;
	}

	public double calcNetForceExertedByX(CelestialBody[] bodies) {
		double sumX = 0;
		for(CelestialBody i : bodies){
			if(! i.equals(this)){
			sumX += calcForceExertedByX(i);
		}
		}
		return sumX;
	}

	public double calcNetForceExertedByY(CelestialBody[] bodies) {
		double sumY = 0;
		for(CelestialBody iy : bodies){
			if(! iy.equals(this)){
				sumY += calcForceExertedByY(iy);
			}
		}
		return sumY;
	}

	public void update(double deltaT, 
			           double xforce, double yforce) {
		double accelerationX = 0;
		double accelerationY = 0;
		double nvx = 0;
		double nvy = 0;
		double newX = 0;
		double newY = 0;
		accelerationX = xforce / myMass;
		accelerationY = yforce/ myMass;
		nvx = myXVel + deltaT * accelerationX;
		nvy = myYVel + deltaT * accelerationY;
		newX = myXPos + deltaT *nvx;
		newY = myYPos + deltaT *nvy;
		myXPos = newX;
		myYPos = newY;
		myYVel = nvy;
		myXVel = nvx;



	}

	public void draw() {
		StdDraw.picture(myXPos, myYPos, "images/" + myFileName);
	}
}
