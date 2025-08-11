import java.util.Map;
import java.util.TreeMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main (String[] args) {
//TODO: Methods like computeIfPresent(), computeIfAbsent()Practical implementations
        TreeMap<Integer, String> userMap = new TreeMap<>();
        userMap.put(1, "Riya");
        userMap.put(2, "Piya");
        userMap.put(3, "Priya");
        userMap.put(4, "Neha");
        userMap.put(5, "Viraj");
        userMap.put(6, "Raj");
        userMap.put(7, "Ram");
        System.out.println(userMap);

        System.out.println(userMap.getOrDefault(1, "Not Found"));
        System.out.println(userMap.getOrDefault(10, "Not Found"));
//        if key found returns value else returns default value(not found in this case)

        System.out.println(userMap.firstKey()); //method from treemap
        System.out.println(userMap.lastKey()); //method from treemap

        userMap.forEach((k,v)-> System.out.println("UserId:" +k+" UserName: " +v));
        userMap.replace(2, "Sneha");
        System.out.println(userMap);

//        userMap.replaceAll((k,v)-> "Sneha");// replaces all values with Sneha(given value)
//        System.out.println(userMap);
        userMap.putIfAbsent(8, "Rohan");
        System.out.println(userMap);
//        userMap.putIfAbsent(1, "Rohan"); if key is already present then
//        System.out.println(userMap);it will not replace the value

        userMap.computeIfAbsent(9, k-> "Sohan");
        System.out.println(userMap);
//        if key is missing or null then computes a new value using given function and adds to map
        userMap.computeIfPresent(1, (k,v)-> v+" Mehta");
        System.out.println(userMap);
//        if key is present then computes a new value using given function and replaces the value
        userMap.compute(9, (k,v)-> "Mr. "+v);
        System.out.println(userMap);
        userMap.compute(10, (k,v)-> "Mr. "+v);
        System.out.println(userMap);
//        in this case the key is not present hence v=null therefore adds value as Mr. null
        userMap.compute(11, (k,v)-> "Rita");
        System.out.println(userMap);

        userMap.merge(11, "K.", (v1,v2)-> v1+" "+v2);
        System.out.println(userMap);
        userMap.merge(12, "Rishi", (v1,v2)-> v1+v2);
        System.out.println(userMap);
//        if key is present then merges the values using given function else adds the value
        userMap.subMap(2, true, 5, true).forEach((k,v)-> System.out.println("UserId:" +k+" UserName: " +v));

        userMap.remove(10, "Mr. "+null);
        System.out.println(userMap);



    }
}