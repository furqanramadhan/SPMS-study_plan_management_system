public class SystemUtils {
    public final void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            System.out.println("OS: " + os);

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
                System.out.print("\033\143");
            }
        } catch (final Exception e) {
            // Handle any exceptions.
            System.out.println("Error clearing console: " + e.getMessage());
        }
    }
}
