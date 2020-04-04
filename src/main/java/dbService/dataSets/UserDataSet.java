package dbService.dataSets;


@SuppressWarnings("UnusedDeclartion")
public class UserDataSet {

    private long id;
    private String name;

    public UserDataSet(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "UsersDataSet{" +
                "id: " + getId() +
                ", name: '" + getName() + "'}";
    }
}
