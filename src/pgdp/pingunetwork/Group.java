package pgdp.pingunetwork;

// TODO: Erweitere die Klasse entsprechend der Aufgabenstellung so, dass ein Bild für die Gruppe dargestellt werden kann.
public class Group {
    private User owner;
    private String name;
    private String description;
    private User[] members;

    public Group(String name, String description, User owner) {
        this.name = name;
        this.description = description;
        this.owner = owner;
        members = new User[1];
        members[0] = owner;
    }

    /** Fügt den übergebenen Nutzer in das 'members'-Array mit ein.
     * @param user Ein beliebiges User-Objekt
     */
    public void addUser(User user) {
        User[] nMembers = new User[members.length + 1];

        for (int  i = 0; i < members.length; i++) {
            if (members[i] == user) {
                return;
            }
            nMembers[i] = members[i];
        }
        nMembers[nMembers.length - 1] = user;
        members = nMembers;

    }

    /** Entfernt das übergebene User-Objekt aus dem 'members'-Array.
     *  Wenn der entfernte Nutzer der Gruppen-Admin war, wird diese Position
     *  entsprechend auf den ersten im übrigen Array angepasst.
     *  Wenn der übergebene Nutzer gar nicht in der Gruppe ist, geschieht nichts.
     * @param user Ein beliebiges User-Objekt.
     */
    public void removeUser(User user) {
        User[] nMembers = new User[members.length - 1];
        boolean found = false;
        boolean isOwner = false;

        for (int  i = 0; i < members.length; i++) {
            if (members[i] != user) {
                int index;
                if(found) {
                    index = i - 1;
                } else {
                    index = i;
                }
                nMembers[index] = members[i];
            } else {
                found = true;
                //falls owner entfernt wird
                if (members[i] == owner) {
                    isOwner = true;
                }
            }
        }
        if (found) {
            //erster aus members[] wird owner
            if (isOwner) {
                owner = nMembers[0];
            }
            members = nMembers;
        }
    }

    /* ================ Getter und Setter ================ */

    public User getOwner() {
        return owner;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public User[] getMembers() {
        return members;
    }

    public void setOwner(User owner) {
        for (int i = 0; i < members.length; i++) {
            if (members[i] == owner) {
                this.owner = owner;
                break;
            }
        }
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
