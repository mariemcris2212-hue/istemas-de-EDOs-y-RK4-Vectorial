public class Main {
    public static void main(String[] args) {
        double t0 = 0.0;
        double h = 0.2;       // Cambiar a 0.1 y 0.05 para las pruebas experimentales
        int nPuntos = 25;     // Cantidad de puntos a calcular después del inicial

        double[] Y = {1.0, 0.0}; // Condiciones iniciales: q(0) = 1.0, q'(0) = 0.0
        double t = t0;

        System.out.println("n\t t_n\t y1 (Carga)\t y2 (Corr)\t q_exacta\t Error Abs");
        System.out.println("--------------------------------------------------------------------------");

        double qEx0 = RK4CircuitoRLC.solucionExacta(t);
        double err0 = Math.abs(qEx0 - Y[0]);
        System.out.printf("%d\t %.2f\t %.6f\t %.6f\t %.6f\t %.2e\n", 0, t, Y[0], Y[1], qEx0, err0);

        for (int i = 0; i < nPuntos; i++) {
            double[] k1 = RK4CircuitoRLC.evaluarSistema(t, Y);
            double[] k2 = RK4CircuitoRLC.evaluarSistema(t + h / 2.0, RK4CircuitoRLC.sumaEscalada(Y, h / 2.0, k1));
            double[] k3 = RK4CircuitoRLC.evaluarSistema(t + h / 2.0, RK4CircuitoRLC.sumaEscalada(Y, h / 2.0, k2));

            // TODO 2: Calcula el vector pendiente k4
            double[] k4 = RK4CircuitoRLC.evaluarSistema(t + h, RK4CircuitoRLC.sumaEscalada(Y, h, k3));

            // TODO 3: Actualiza cada componente de Y[j] usando la fórmula ponderada de RK4
            for (int j = 0; j < Y.length; j++) {
                Y[j] = Y[j] + (h / 6.0) * (k1[j] + 2.0 * k2[j] + 2.0 * k3[j] + k4[j]);
            }

            t += h;
            double qEx = RK4CircuitoRLC.solucionExacta(t);
            double errorAbs = Math.abs(qEx - Y[0]);

            System.out.printf("%d\t %.2f\t %.6f\t %.6f\t %.6f\t %.2e\n", (i + 1), t, Y[0], Y[1], qEx, errorAbs);
        }
    }
}
