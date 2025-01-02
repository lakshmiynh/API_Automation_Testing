package API_Automation;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class Spotify_API_testing {
    String token = "BQCxMKu-IrGxSxlRlMNYYdanjuG4qlx8sYPZighw3AIlbdciykbDKjHnATWZ79Xd3RjxXjefeIlgqx2T0cnfyRQf156J7L_Gu1-mweikQl2cEcGs_0m45wj_nKprswJHgEVaZFqTF1aOQ5t3VV7fVvRfnkLidWk5ghYjXHBMOQ0xmqmlRdNON5SBoy5pmuReqS0bNarnzQjIQiuvlT96vv1AUYqe7CPhQZGLP0_04GOlBjfRqVRM5x5wrO_OsQC-X3LtIRyBquatfRxhgSYhfeHUYF6Ti_UsFrmsWEN9LF1vOMqShb1kBov6JMY2S2UPBe78gFsap3AD02Zy7f4cE1J5PXtM";
    String token1="BQByafV4ySV96KzXsQWA8ep-7yMlk3h94qTAXidFrG-pG_ObInxQcZnADx1V-vzjcj_In8Y7q5TCNVhJJ4psGZw70GJjXV9CGEtMfM2QWjHhzPhxso6r-rOn3m5H5pDun7pjq2WL3qyOb9I6S7rBlrORsMRka_ieZB3qgThuJXpUfNq_UTjOGNt2cB4GxAl4FhEujBsNm7-S0n_W0SO8D3tEY4gomGqiExfvQAyYRjT-OAVTBl7mpNHWud1pLMHF73yCyF3tIyguNpIzF5GozdzAICCUNRlpb6wxw2Yu9ObNTaXP-LUTKfhCLTe-8rG80YFMNdx7MLH2-HKwsrhkxngzj706";
    @Test
    public void getUserProfile() {
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/me");

        response.then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void getUsersTopItems() {
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/me/top/artists");

        response.then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void getFollowedArtists() {
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("type", "artist")
                .when()
                .get("https://api.spotify.com/v1/me/following");

        response.then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void followPlaylist() {
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .when()
                .put("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/followers");

        response.then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void unfollowPlaylist() {
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .when()
                .delete("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/followers");

        response.then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void followArtistOrUser() {
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("type", "artist")
                .queryParam("ids", "2CIMQHirSU0MQqyYHq0eOx,57dN52uHvrHOxijzpIgu3E,1vCWHaC5f2uS3yhpwWbIA6")
                .when()
                .put("https://api.spotify.com/v1/me/following");

        response.then()
                .statusCode(204)
                .log().all();
    }

    @Test
    public void unfollowArtistOrUser() {
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("type", "artist")
                .queryParam("ids", "2CIMQHirSU0MQqyYHq0eOx,57dN52uHvrHOxijzpIgu3E,1vCWHaC5f2uS3yhpwWbIA6")
                .when()
                .delete("https://api.spotify.com/v1/me/following");

        response.then()
                .statusCode(204)
                .log().all();
    }

    @Test
    public void checkIfUserFollowsArtistsOrUsers() {
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("type", "artist")
                .queryParam("ids", "2CIMQHirSU0MQqyYHq0eOx,57dN52uHvrHOxijzpIgu3E,1vCWHaC5f2uS3yhpwWbIA6")
                .when()
                .get("https://api.spotify.com/v1/me/following/contains");

        response.then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void checkIfUserFollowsPlaylist() {
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/followers/contains");

        response.then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void getCurrentUserProfile() {
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/me");

        response.then()
                .statusCode(200)
                .log().all();
    }

    // API Testing for Search
    @Test
    public void searchForItem() {
        Response response = given()
                .header("Authorization", "Bearer " + token) // Replace with a valid token
                .queryParam("q", "remaster track:Doxy artist:Miles Davis") // Adjust query as needed
                .queryParam("type", "album") // Specify the type of item to search for
                .when()
                .get("https://api.spotify.com/v1/search");

        response.then()
                .statusCode(200) // Verify the success status code
                .log().all(); // Log the response for debugging purposes
    }

    // API Testing for Playlist
    @Test
    public void getPlaylist() {
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n");

        response.then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void changePlaylistDetails() {
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body("{ \"name\": \"Updated Playlist Name\", \"description\": \"Updated playlist description\", \"public\": true }")
                .when()
                .put("https://api.spotify.com/v1/playlists/4HziSK5kt0q5hiUDCO3HLW");

        response.then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void getPlaylistItems() {
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/tracks");

        response.then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void addItemToPlaylist() {
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body("{ \"uris\": [\"spotify:track:0Ru7ofoQuzZ4BnPdK9M8cJ\"], \"position\": 0 }")
                .when()
                .post("https://api.spotify.com/v1/playlists/4HziSK5kt0q5hiUDCO3HLW/tracks");

        response.then()
                .statusCode(201)
                .log().all();
    }

    @Test
    public void removePlaylistItem() {
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body("{ \"tracks\": [ { \"uri\": \"spotify:track:0Ru7ofoQuzZ4BnPdK9M8cJ\" } ], \"snapshot_id\": \"AAAABvRVe/QrDhCVQIFxqjia/bvCQWvq\" }")
                .when()
                .delete("https://api.spotify.com/v1/playlists/4HziSK5kt0q5hiUDCO3HLW/tracks");

        response.then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void getCurrentUsersPlaylists() {
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/me/playlists");

        response.then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void getUsersPlaylists() {
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body("{ \"name\": \"Newsongs2\", \"description\": \"New playlist for 2025\", \"public\": true }")
                .when()
                .post("https://api.spotify.com/v1/users/31fhmqvsl3nmo6gxirm6qlehkx3i/playlists");

        response.then()
                .statusCode(201)
                .log().all();
    }

    @Test
    public void getFeaturedPlaylists() {
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/browse/featured-playlists");

        response.then()
                .statusCode(404)
                .log().all();
    }

    // API Testing for Tracks
    @Test
    public void getTrack() {
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/tracks/11dFghVXANMlKmJXsNCbNl"); // Replace with the track ID you want to test

        response.then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void getSeveralTracks() {
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("ids", "7ouMYWpwJ422jRcDASZB7P,4VqPOruhp5EdPBeR92t6lQ,2takcwOaAZWiXQijPHIx7B") // Replace with track IDs
                .when()
                .get("https://api.spotify.com/v1/tracks");

        response.then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void getUsersSavedTracks() {
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/me/tracks");

        response.then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void saveTracksForCurrentUser() {
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body("{ \"ids\": [\"0n6NBNUZQmH1KGRt5J9Nkq\"] }") // Replace with the track IDs to save
                .when()
                .put("https://api.spotify.com/v1/me/tracks");

        response.then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void removeUsersSavedTracks() {
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body("{ \"ids\": [\"0n6NBNUZQmH1KGRt5J9Nkq\"] }") // Replace with the track IDs to remove
                .when()
                .delete("https://api.spotify.com/v1/me/tracks");

        response.then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void checkUsersSavedTracks() {
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("ids", "0n6NBNUZQmH1KGRt5J9Nkq") // Replace with the track IDs to check
                .when()
                .get("https://api.spotify.com/v1/me/tracks/contains");

        response.then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void getSeveralTracksAudioFeatures() {
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("ids", "5JW3pp03IS7ZJYiHaVCqja") // Replace with track IDs
                .when()
                .get("https://api.spotify.com/v1/audio-features");

        response.then()
                .statusCode(403)
                .log().all();
    }
    // API testing for show

    @Test
    public void getShow() {
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/shows/38bS44xjbVVZ3No3ByF1dJ");

        response.then()
                .statusCode(404)
                .log().all();
    }

    @Test
    public void getSeveralShows() {
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("ids", "38bS44xjbVVZ3No3ByF1dJ,4AlxqGkkrqe0mfIx3Mi7Xt")
                .when()
                .get("https://api.spotify.com/v1/shows");

        response.then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void getShowEpisodes() {
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("market", "US")
                .when()
                .get("https://api.spotify.com/v1/shows/38bS44xjbVVZ3No3ByF1dJ/episodes");

        response.then()
                .statusCode(404)
                .log().all();
    }

    @Test
    public void getUsersSavedShows() {
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/me/shows");

        response.then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void saveShowsForCurrentUser() {
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .when()
                .put("https://api.spotify.com/v1/me/shows?ids=5CfCWKI5pZ28U0uOzXkDHe%2C5as3aKmN2k11yfDDDSrvaZ");

        response.then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void removeUsersSavedShows() {
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body("{ \"ids\": [\"38bS44xjbVVZ3No3ByF1dJ\"] }")
                .when()
                .delete("https://api.spotify.com/v1/me/shows?ids=5CfCWKI5pZ28U0uOzXkDHe%2C5as3aKmN2k11yfDDDSrvaZ");

        response.then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void checkUsersSavedShows() {
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("ids", "38bS44xjbVVZ3No3ByF1dJ")
                .when()
                .get("https://api.spotify.com/v1/me/shows/contains");

        response.then()
                .statusCode(200)
                .log().all();
    }

    // API testing for Player use token spotify token1
    @Test
    public void getPlaybackState() {
        Response response = given()
                .header("Authorization", "Bearer " + token1)
                .when()
                .get("https://api.spotify.com/v1/me/player");

        response.then()
                .statusCode(204)
                .log().all();
    }

    @Test
    public void transferPlayback() {
        Response response = given()
                .header("Authorization", "Bearer " + token1)
                .contentType("application/json")
                .when()
                .get("https://api.spotify.com/v1/me/player");

        response.then()
                .statusCode(204) // No content response for successful transfer
                .log().all();
    }

    @Test
    public void getAvailableDevices() {
        Response response = given()
                .header("Authorization", "Bearer " + token1)
                .when()
                .get("https://api.spotify.com/v1/me/player/devices");

        response.then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void getCurrentlyPlayingTrack() {
        Response response = given()
                .header("Authorization", "Bearer " + token1)
                .when()
                .get("https://api.spotify.com/v1/me/player/currently-playing");

        response.then()
                .statusCode(204)
                .log().all();
    }

    @Test
    public void startOrResumePlayback() {
        Response response = given()
                .header("Authorization", "Bearer " + token1)
                .contentType("application/json")
                .body("{ \"uris\": [\"spotify:track:11dFghVXANMlKmJXsNCbNl\"] }") // Replace with your track URI
                .when()
                .put("https://api.spotify.com/v1/me/player/play");

        response.then()
                .statusCode(403)
                .log().all();
    }

    @Test
    public void pausePlayback() {
        Response response = given()
                .header("Authorization", "Bearer " + token1)
                .when()
                .put("https://api.spotify.com/v1/me/player/pause");

        response.then()
                .statusCode(403)
                .log().all();
    }

    @Test
    public void skipToNextTrack() {
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .when()
                .post("https://api.spotify.com/v1/me/player/next");

        response.then()
                .statusCode(204)
                .log().all();
    }

    @Test
    public void skipToPreviousTrack() {
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .when()
                .post("https://api.spotify.com/v1/me/player/previous");

        response.then()
                .statusCode(204)
                .log().all();
    }

    // API Testing for markets
    @Test
    public void getAvailableMarkets() {
        Response response = given()
                .header("Authorization", "Bearer " + token1) // Replace with a valid token
                .when()
                .get("https://api.spotify.com/v1/markets");

        response.then()
                .statusCode(200) // Verify the success status code
                .log().all(); // Log the response for debugging purposes
    }

    // API testing for Genres
    @Test
    public void getAvailablegenreseeds() {
        Response response = given()
                .header("Authorization", "Bearer " + token1) // Replace with a valid token
                .when()
                .get("https://api.spotify.com/v1/recommendations/available-genre-seeds");

        response.then()
                .statusCode(200) // Verify the success status code
                .log().all();
    }

    // API Testing for Chapter
    @Test
    public void getchapter() {
        Response response = given()
                .header("Authorization", "Bearer " + token1) // Replace with a valid token
                .when()
                .get("https://api.spotify.com/v1/chapters/0D5wENdkdwbqlrHoaJ9g29");

        response.then()
                .statusCode(404) // Verify the success status code
                .log().all();
    }
    @Test
    public void getseveralchapter() {
        Response response = given()
                .header("Authorization", "Bearer " + token1) // Replace with a valid token
                .when()
                .get("https://api.spotify.com/v1/chapters?ids=0IsXVP0JmcB2adSE338GkK%2C3ZXb8FKZGU0EHALYX6uCzU%2C0D5wENdkdwbqlrHoaJ9g29");

        response.then()
                .statusCode(200) // Verify the success status code
                .log().all();
    }
    // Api testing for categories
    @Test
    public void getseveralbrowsecategories() {
        Response response = given()
                .header("Authorization", "Bearer " + token1) // Replace with a valid token
                .when()
                .get("https://api.spotify.com/v1/chapters?ids=0IsXVP0JmcB2adSE338GkK%2C3ZXb8FKZGU0EHALYX6uCzU%2C0D5wENdkdwbqlrHoaJ9g29");

        response.then()
                .statusCode(200) // Verify the success status code
                .log().all();
    }

    @Test
    public void getsinglebrowsercategory() {
        Response response = given()
                .header("Authorization", "Bearer " + token1) // Replace with a valid token
                .when()
                .get("https://api.spotify.com/v1/browse/categories/dinner");

        response.then()
                .statusCode(200) // Verify the success status code
                .log().all();
    }
   // api testing for artist
   @Test
   public void getArtist() {
       Response response = given()
               .header("Authorization", "Bearer " + token1) // Replace with a valid token
               .when()
               .get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg");

       response.then()
               .statusCode(200) // Verify the success status code
               .log().all();
   }

    @Test
    public void getseveralartists() {
        Response response = given()
                .header("Authorization", "Bearer " + token1) // Replace with a valid token
                .when()
                .get("https://api.spotify.com/v1/artists?ids=2CIMQHirSU0MQqyYHq0eOx%2C57dN52uHvrHOxijzpIgu3E%2C1vCWHaC5f2uS3yhpwWbIA6");

        response.then()
                .statusCode(200) // Verify the success status code
                .log().all();
    }
    @Test
    public void getartistalbums() {
        Response response = given()
                .header("Authorization", "Bearer " + token1) // Replace with a valid token
                .when()
                .get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg/albums");

        response.then()
                .statusCode(200) // Verify the success status code
                .log().all();
    }
    @Test
    public void getartistrelatedartists() {
        Response response = given()
                .header("Authorization", "Bearer " + token1) // Replace with a valid token
                .when()
                .get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg/related-artists");

        response.then()
                .statusCode(404) // Verify the success status code
                .log().all();
    }
    @Test
    public void getartisttoptracks() {
        Response response = given()
                .header("Authorization", "Bearer " + token1) // Replace with a valid token
                .when()
                .get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg/top-tracks");

        response.then()
                .statusCode(200) // Verify the success status code
                .log().all();
    }
    // api testing for album
    @Test
    public void getalbum() {
        Response response = given()
                .header("Authorization", "Bearer " + token1) // Replace with a valid token
                .when()
                .get("https://api.spotify.com/v1/albums/4aawyAB9vmqN3uQ7FjRGTy");

        response.then()
                .statusCode(200) // Verify the success status code
                .log().all();
    }
    @Test
    public void getseveralalbum() {
        Response response = given()
                .header("Authorization", "Bearer " + token1) // Replace with a valid token
                .when()
                .get("https://api.spotify.com/v1/albums?ids=382ObEPsp2rxGrnsizN5TX%2C1A2GTWGtFfWp7KSQTwWOyo%2C2noRn2Aes5aoNVsU6iWThc");

        response.then()
                .statusCode(200) // Verify the success status code
                .log().all();
    }

    @Test
    public void getalbumtrack() {
        Response response = given()
                .header("Authorization", "Bearer " + token1) // Replace with a valid token
                .when()
                .get("https://api.spotify.com/v1/albums/4aawyAB9vmqN3uQ7FjRGTy/tracks");

        response.then()
                .statusCode(200) // Verify the success status code
                .log().all();
    }
    @Test
    public void getusersavedalbums() {
        Response response = given()
                .header("Authorization", "Bearer " + token1) // Replace with a valid token
                .when()
                .get("https://api.spotify.com/v1/me/albums");

        response.then()
                .statusCode(200) // Verify the success status code
                .log().all();
    }
    @Test
    public void savealbumsforcurrentuser() {
        Response response = given()
                .header("Authorization", "Bearer " + token1) // Replace with a valid token
                .when()
                .put("https://api.spotify.com/v1/me/albums?ids=382ObEPsp2rxGrnsizN5TX%2C1A2GTWGtFfWp7KSQTwWOyo%2C2noRn2Aes5aoNVsU6iWThc");

        response.then()
                .statusCode(200) // Verify the success status code
                .log().all();
    }
    @Test
    public void removeusersavedalbum() {
        Response response = given()
                .header("Authorization", "Bearer " + token1) // Replace with a valid token
                .when()
                .delete("https://api.spotify.com/v1/me/albums?ids=382ObEPsp2rxGrnsizN5TX%2C1A2GTWGtFfWp7KSQTwWOyo%2C2noRn2Aes5aoNVsU6iWThc");

        response.then()
                .statusCode(200) // Verify the success status code
                .log().all();
    }

    @Test
    public void checkusersavedalbums() {
        Response response = given()
                .header("Authorization", "Bearer " + token1) // Replace with a valid token
                .when()
                .get("https://api.spotify.com/v1/me/albums/contains?ids=382ObEPsp2rxGrnsizN5TX%2C1A2GTWGtFfWp7KSQTwWOyo%2C2noRn2Aes5aoNVsU6iWThc");

        response.then()
                .statusCode(200) // Verify the success status code
                .log().all();
    }
    @Test
    public void getnewreleases() {
        Response response = given()
                .header("Authorization", "Bearer " + token1) // Replace with a valid token
                .when()
                .get("https://api.spotify.com/v1/browse/new-releases");

        response.then()
                .statusCode(200) // Verify the success status code
                .log().all();
    }
    // api testing for audiobooks
    @Test
    public void getanaudiobook() {
        Response response = given()
                .header("Authorization", "Bearer " + token1) // Replace with a valid token
                .when()
                .get("https://api.spotify.com/v1/audiobooks/31fhmqvsl3nmo6gxirm6qlehkx3i");

        response.then()
                .statusCode(400) // Verify the success status code
                .log().all();
    }
    @Test
    public void getaudioseveralbook() {
        Response response = given()
                .header("Authorization", "Bearer " + token1) // Replace with a valid token
                .when()
                .get("https://api.spotify.com/v1/audiobooks?ids=18yVqkdbdRvS24c0Ilj2ci%2C1HGw3J3NxZO1TP1BTtVhpZ%2C7iHfbu1YPACw6oZPAFJtqe");

        response.then()
                .statusCode(400) // Verify the success status code
                .log().all();
    }

    @Test
    public void getaudiobookchapter() {
        Response response = given()
                .header("Authorization", "Bearer " + token1) // Replace with a valid token
                .when()
                .get("https://api.spotify.com/v1/audiobooks/7iHfbu1YPACw6oZPAFJtqe/chapters");

        response.then()
                .statusCode(404) // Verify the success status code
                .log().all();
    }

    @Test
    public void getusersavedaudiobooks() {
        Response response = given()
                .header("Authorization", "Bearer " + token1) // Replace with a valid token
                .when()
                .get("https://api.spotify.com/v1/me/audiobooks");

        response.then()
                .statusCode(200) // Verify the success status code
                .log().all();
    }
    @Test
    public void savedaudiobookforuser() {
        Response response = given()
                .header("Authorization", "Bearer " + token1) // Replace with a valid token
                .when()
                .put("https://api.spotify.com/v1/me/audiobooks?ids=18yVqkdbdRvS24c0Ilj2ci%2C1HGw3J3NxZO1TP1BTtVhpZ%2C7iHfbu1YPACw6oZPAFJtqe");

        response.then()
                .statusCode(200) // Verify the success status code
                .log().all();
    }
    @Test
    public void removesavedaudiobooks() {
        Response response = given()
                .header("Authorization", "Bearer " + token1) // Replace with a valid token
                .when()
                .delete("https://api.spotify.com/v1/me/audiobooks?ids=18yVqkdbdRvS24c0Ilj2ci%2C1HGw3J3NxZO1TP1BTtVhpZ%2C7iHfbu1YPACw6oZPAFJtqe");

        response.then()
                .statusCode(200) // Verify the success status code
                .log().all();
    }
    @Test
    public void checkusersavedaudiobook() {
        Response response = given()
                .header("Authorization", "Bearer " + token1) // Replace with a valid token
                .when()
                .get("https://api.spotify.com/v1/me/audiobooks/contains?ids=18yVqkdbdRvS24c0Ilj2ci%2C1HGw3J3NxZO1TP1BTtVhpZ%2C7iHfbu1YPACw6oZPAFJtqe");

        response.then()
                .statusCode(200) // Verify the success status code
                .log().all();
    }
    // api testing for episodes
    @Test
    public void getepisodes() {
        Response response = given()
                .header("Authorization", "Bearer " + token1) // Replace with a valid token
                .when()
                .get("https://api.spotify.com/v1/episodes/512ojhOuo1ktJprKbVcKyQ");

        response.then()
                .statusCode(404) // Verify the success status code
                .log().all();
    }
    @Test
    public void getseveraklepisodes() {
        Response response = given()
                .header("Authorization", "Bearer " + token1) // Replace with a valid token
                .when()
                .get("https://api.spotify.com/v1/episodes?ids=77o6BIVlYM3msb4MMIL1jH%2C0Q86acNRm6V9GYx55SXKwf");

        response.then()
                .statusCode(200) // Verify the success status code
                .log().all();
    }
    @Test
    public void getusersavedepisodes() {
        Response response = given()
                .header("Authorization", "Bearer " + token1) // Replace with a valid token
                .when()
                .get("https://api.spotify.com/v1/me/episodes");

        response.then()
                .statusCode(200) // Verify the success status code
                .log().all();
    }
    @Test
    public void saveepisodescurrentuser() {
        Response response = given()
                .header("Authorization", "Bearer " + token1) // Replace with a valid token
                .when()
                .put("https://api.spotify.com/v1/me/episodes?ids=77o6BIVlYM3msb4MMIL1jH%2C0Q86acNRm6V9GYx55SXKwf");

        response.then()
                .statusCode(200) // Verify the success status code
                .log().all();
    }
    @Test
    public void removeusersavedepisodes() {
        Response response = given()
                .header("Authorization", "Bearer " + token1) // Replace with a valid token
                .when()
                .delete("https://api.spotify.com/v1/me/episodes?ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B");

        response.then()
                .statusCode(200) // Verify the success status code
                .log().all();
    }
    @Test
    public void checkusersavedepisodes() {
        Response response = given()
                .header("Authorization", "Bearer " + token1) // Replace with a valid token
                .when()
                .get("https://api.spotify.com/v1/me/episodes/contains?ids=77o6BIVlYM3msb4MMIL1jH%2C0Q86acNRm6V9GYx55SXKwf");

        response.then()
                .statusCode(200) // Verify the success status code
                .log().all();
    }
}

