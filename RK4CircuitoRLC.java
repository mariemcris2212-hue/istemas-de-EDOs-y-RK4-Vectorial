public class RK4CircuitoRLC {

    // Vector de derivadas F(t,Y) donde Y[0] = y1 (carga) e Y[1] = y2 (corriente)
    public static double[] evaluarSistema(double t, double[] Y) {
        double y1 = Y[0];
        double y2 = Y[1];

        // TODO 1: Expresiones para dy1/dt y dy2/dt según el sistema equivalente
        double dy1 = y2;
        double dy2 = -y1 - 0.4 * y2;

        return new double[]{dy1, dy2};
    }

    // Suma vectorial escalada: res[i] = A[i] + factor * B[i]
    public static double[] sumaEscalada(double[] A, double factor, double[] B) {
        int n = A.length;
        double[] res = new double[n];
        for (int i = 0; i < n; i++) {
            res[i] = A[i] + factor * B[i];
        }
        return res;
    }

    // Función auxiliar para calcular la solución analítica exacta (Actividad 3)
    public static double solucionExacta(double t) {
        double wd = Math.sqrt(0.96);
        return Math.exp(-0.2 * t) * (Math.cos(wd * t) + (0.2 / wd) * Math.sin(wd * t));
    }
}