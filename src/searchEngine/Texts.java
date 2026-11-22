package searchEngine;

public enum Texts {
    SEARCH("[/quit to end search]\nSearch: "),
    RESULTS("\n~~~Results~~~"),
    NO_RESULTS("No results..."),
    CLIENT_CHOOSE("Server is missing!\nReconnect: Any other key\nQuit: /quit\nChoose: "),
    END_SEARCH("End search..."),
    FILE("src/searchEngine/database"),
    DATABASE_NOT_FOUND("Database not found "),
    SEARCH_IS_LIVE("Search engine is live!");

    private final String text;
    Texts(String code) {this.text = code;}

    @Override
    public String toString() {return text;}
}
