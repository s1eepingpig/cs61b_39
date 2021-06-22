class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xxPos, double yyPos, double xxVel, double yyVel, double mass, String imgFileName) {
        this.xxPos = xxPos;
        this.yyPos = yyPos;
        this.xxVel = xxVel;
        this.yyVel = yyVel;
        this.mass = mass;
        this.imgFileName = imgFileName;
    }

    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    double calcDistance(Planet p) {
        double x = Math.abs(p.xxPos - xxPos);
        double y = Math.abs(p.yyPos - yyPos);
        if (x == 0.0) {
            if (y != 0.0) {
                return y;
            }
            return 0.0;
        }
        if (y == 0.0) {
            if (x != 0.0) {
                return x;
            }
            return 0.0;
        }
        x = x * x;
        y = y * y;
        double distance = Math.sqrt(x + y);
        return distance;
    }

    //Calculate the total Force
    public double calcForceExertedBy(Planet p) {
        double r = calcDistance(p);
        double r2 = r * r;
        double G = 6.67e-11;
        double mass1 = this.mass;
        double mass2 = p.mass;
        double up = G * mass1 * mass2;
        double F1 = up / r2;
        return F1;
    }

    //Caculate the X position Force
    public double calcForceExertedByX(Planet p) {
        //Distance of two planets
        double distance = calcDistance(p);
        double x0 = this.xxPos;
        double x1 = p.xxPos;
        double F = calcForceExertedBy(p);
        double div = (x1 - x0) / distance;
        double F1x = F * div;
        return F1x;
    }

    public double calcForceExertedByY(Planet p) {
        double y0 = this.yyPos;
        double y1 = p.yyPos;
        double distance = calcDistance(p);
        double F = calcForceExertedBy(p);
        double div = (y1 - y0) / distance;
        double F1y = F * div;
        return F1y;
    }

    public double calcNetForceExertedByX(Planet[] Ps) {
        double ExertByX = 0;
        for (Planet p : Ps) {
            if (!this.equals(p)) {
                double v = this.calcForceExertedByX(p);
                ExertByX += v;
            }
        }
        return ExertByX;

    }

    public double calcNetForceExertedByY(Planet[] Ps) {

        double ExertByY = 0;
        for (Planet p :
                Ps) {
            if (this.equals(p) == false) {
                double v = this.calcForceExertedByY(p);
                ExertByY += v;
            }
        }
        return ExertByY;
    }

    //To update the velocity of the planet.
    public void update(double time, double fx, double fy) {
        //Calculate the accurate of planet

        double ax = fx / this.mass;
        double ay = fy / this.mass;
        //allocate new a to planet
        // F = m * a V = a * t (What the F,Nearly forgot all of the formulate in senior high school)

        this.xxVel += ax * time;
        this.yyVel += ay * time;
        this.xxPos += time * xxVel;
        this.yyPos += time * yyVel;
    }

    //Drawing the planet on the screen
    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "/images/" + this.imgFileName);

    }


}