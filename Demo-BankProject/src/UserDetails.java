import java.util.ArrayList;
import java.util.Arrays;

public class UserDetails {
    static VTree<Long, String> users = new VTree<>();
    static ArrayList<Long> timerList = new ArrayList<>();

    static Long[] userIds = {1736862250415L, 1736862250416L, 1736862250418L, 1736862250419L, 1736862250420L, 1736862250421L, 1736862250422L, 1736862250423L, 1736862250424L, 1736862250425L, 1736862250426L, 1736862250427L, 1736862250428L, 1736862250430L, 1736862250431L, 1736862250432L, 1736862250433L, 1736862250434L, 1736862250435L, 1736862250436L, 1736862250437L, 1736862250438L, 1736862250439L, 1736862250440L, 1736862250441L};
    static String[]  userNames = {"Aarav", "Ananya", "Arjun", "Aditi", "Ishaan", "Riya", "Vivaan", "Diya", "Kabir", "Kiara", "Siddharth", "Meera", "Krishna", "Radha", "Akshay", "Neha", "Rajesh", "Pooja", "Manoj", "Sneha", "Rakesh", "Shruti", "Rahul", "Priya", "Kiran"};

    static public void loadUserNames() {
        UserDetails.users.insertBulk(UserDetails.userIds, UserDetails.userNames);
    }

    static public void foundName(long userId) {
        loadUserNames();
        VEntry<Long, String> userNameEntries = users.get(userId);
        System.out.println("Person Name - " + userNameEntries.getValue());
    }
}
