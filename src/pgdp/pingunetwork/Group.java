package pgdp.pingunetwork;

// TODO: Erweitere die Klasse entsprechend der Aufgabenstellung so, dass ein Bild für die Gruppe dargestellt werden kann.
public class Group {
    private User owner;
    private String name;
    private String description;
    private Picture picture; //picture nicht array
    private User[] members;

    public Group(String name, String description, User owner, Picture picture) {
        this.name = name;
        this.description = description;
        this.owner = owner;
        this.picture = picture;
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
        //falls User Array leer
        if (members == null || members.length == 0) {
            return;
        }
        //falls user nicht enthalten ist
        boolean not_User = true;
        for (int i = 0; i < members.length; i++) {
            //falls user doch enthalten
            if (members[i] == user) {
                not_User = false;
            }
        }
        if (not_User) {
            return;
        }

        User[] nMembers = new User[members.length - 1];
        boolean found = false;

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
            }
        }
        if (found) {
            members = nMembers;
            //falls owner entfernt wird
            if (user == owner) {
                if (members.length > 0) {
                    owner = members[0];
                } else {
                    owner = null;
                }
            }
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

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
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

    public static void main(String args) {

    }
}
