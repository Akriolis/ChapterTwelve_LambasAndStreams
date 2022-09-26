import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Jukebox {
    public static void main(String[] args) {
        List<Song> songList = new Jukebox().go();
        List<Song> rockList = songList.stream()
                .filter(song -> song.getTitle().startsWith("H"))
                .collect(Collectors.toList());
        //System.out.println(rockList);

        List<String> genresList = songList.stream()
                .map(song -> song.getGenre())
                .distinct()
                .collect(Collectors.toList());
        //System.out.println(genresList);

        String songTitle = "With a Little Help from My Friends";
        List<String> resultList = songList.stream()
                .filter (song -> song.getTitle().equals(songTitle))
                .map(song -> song.getArtist())
                .filter(artist -> !artist.equals("The Beatles"))
                .collect(Collectors.toList());
        System.out.println(resultList);

        // Method references
        Function<Song, String> getGenre = song -> song.getGenre();
        Function<Song, String> getGenre2 = Song::getGenre;
        // both method references does the same

        // from newest to oldest
        List<Song> anotherResult = songList.stream()
                .sorted(((o1, o2) -> o2.getYear() - o1.getYear()))
                .collect(Collectors.toList());
        //System.out.println(anotherResult);

        // from oldest to newest
        List<Song> anotherOneResult = songList.stream()
                .sorted(Comparator.comparingInt(Song::getYear))
                .collect(Collectors.toList());
        //System.out.println(anotherOneResult);


        Set<String> genresSet = songList.stream()
                .map(song -> song.getGenre())
                .collect(Collectors.toSet());
        System.out.println(genresSet);

        //Collectors.toUnmodifiableSet
        //Collectors.toUnmodifiableList
        //Collectors.toUnmodifiableMap
        /**Collectors.joining - join together all the stream elements into a single String
         * optionally you can define delimiter
         */

        String genresString = songList.stream()
                .map(song -> song.getGenre())
                .distinct()
                .collect(Collectors.joining("! "));
        System.out.println(genresString);

        /** You can use another terminal operations!
        */
        boolean result = songList.stream()
                .anyMatch(s -> s.getGenre().equals("R&B"));

        if (result == true){
            System.out.println("Got a match!");
        } else {
            System.out.println("Without matches");
        }
        // anyMatch, allMatch, noneMatch

        // find a specific thing
        Optional<Song> firstByYear = songList.stream()
                .filter(s -> s.getYear() == 1995)
                .findFirst();
        System.out.println(firstByYear);

        // findAny, findFirst, max (Comparator c), min (Comparator c), reduce (BinaryOperator a)

        // count the items
        long counts = songList.stream()
                .map(Song::getArtist)
                .distinct()
                .count();
        System.out.println(counts);

        /**
         * Optional is a wrapper
         * it means you have to check a value it returns
         * to handle the situations if there is no object to return
         * use if/else
         * without checking you will get exception
         */





    }

    List<Song> go(){
        return new Songs().getSongs();
    }

}
