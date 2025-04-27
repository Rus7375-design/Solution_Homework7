public class Main {
    public static void main(String[] args) {
        Season season1 = new Season();
        season1.addEpisode(new Episode("Pilot", 3600));
        season1.addEpisode(new Episode("Episode 2", 3500));
        season1.addEpisode(new Episode("Episode 3", 3400));

        for (Episode e : season1) {
            System.out.println(e.getTitle() + " (" + e.getRuntimeSec() + " sec)");
        }
    }
}
