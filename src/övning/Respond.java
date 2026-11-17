package övning;

public enum Respond {
    MAIN_CHOOSE("Server: 1\nClient: 2\nEnd program: Any other keys\nChoose: "),
    CLIENT_CHOOSE("Server is missing!\nReconnect: Any other key\nQuit: q\nChoose: "),
    CLIENT_CONNECTED("Client connected"),
    SERVER_STARTED("Server started"),
    WAIT_NEXT_CLIENT("Wait for the next client..."),
    SERVER_CONNECTED("Connected: write quit to end this service"),
    SERVER_DISCONNECTED("Server disconnected"),
    WRITE_MESSAGE("Write an message: "),
    YOUR_NAME("Your name please: "),;

    private final String message;
    Respond(String code) {this.message = code;}

    @Override
    public String toString() {return message;}
}
