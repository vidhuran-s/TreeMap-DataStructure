import java.util.ArrayList;

public class UsersBalance {
    static VTree<Long, Integer> userBalanceList = new VTree<>();
    static Long[] userIds = {1736862250415L, 1736862250416L, 1736862250418L, 1736862250419L, 1736862250420L, 1736862250421L, 1736862250422L, 1736862250423L, 1736862250424L, 1736862250425L, 1736862250426L, 1736862250427L, 1736862250428L, 1736862250430L, 1736862250431L, 1736862250432L, 1736862250433L, 1736862250434L, 1736862250435L, 1736862250436L, 1736862250437L, 1736862250438L, 1736862250439L, 1736862250440L, 1736862250441L};
    static Integer[] balanceList = {45678, 92345, 782345, 100245, 342545, 561234, 2345, 678123, 89045, 234678, 90123, 12345, 543678, 234156, 876234, 43567, 892345, 67123, 10345, 87321, 458967, 901245, 342567, 789056, 234156};

    static public void loadUserBalance(){
        userBalanceList.insertBulk(userIds, balanceList);
    }
    static public void foundIt(long userId) {
        loadUserBalance();
        UserDetails.loadUserNames();
        boolean contain = UsersBalance.userBalanceList.contain(userId);
        if (contain) {
            VEntry<Long, Integer> balanceEntry = UsersBalance.userBalanceList.get(userId);
            VEntry<Long, String> userNameEntry = UserDetails.users.get(userId);
            System.out.println("User Balance Details");
            System.out.println(userNameEntry.value+ " - $" +balanceEntry.value);
        }
        else {
            System.out.println("No user found");
        }
    }

    static public void loadAllDetails() {
        loadUserBalance();
        UserDetails.loadUserNames();
        System.out.println("All Users Balance details");
        ArrayList<Integer> balanceEntries = UsersBalance.userBalanceList.getValues();
        ArrayList<String> userNameEntries = UserDetails.users.getValues();
        if (balanceEntries.size() == userNameEntries.size()) {
            for (int i = 0; i < balanceEntries.size(); i++) {
                System.out.println(userNameEntries.get(i) + " - $" + balanceEntries.get(i));
            }
        }
        else {
            System.out.println("Balance - " + balanceEntries.size());
            System.out.println("UserName - " + userNameEntries.size());
        }
    }
}
