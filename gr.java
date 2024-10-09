import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class Group {
    private Set<Integer> elements;

    public Group(Set<Integer> elements) {
        this.elements = elements;
    }

    private boolean contains(int element) {
        return elements.contains(element);
    }

    public boolean isClosedUnderOperation() {
        for (int a : elements) {
            for (int b : elements) {
                if (!contains(a + b)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isAssociative() {
        for (int a : elements) {
            for (int b : elements) {
                for (int c : elements) {
                    if ((a + (b + c)) != ((a + b) + c)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public Integer getIdentityElement() {
        for (int e : elements) {
            boolean isIdentity = true;
            for (int a : elements) {
                if ((e + a) != a || (a + e) != a) {
                    isIdentity = false;
                    break;
                }
            }
            if (isIdentity) {
                return e;
            }
        }
        return null;
    }

    public boolean hasInverseElement() {
        Integer identity = getIdentityElement();
        if (identity == null) {
            return false;
        }
        for (int a : elements) {
            boolean hasInverse = false;
            for (int b : elements) {
                if ((a + b) == identity) {
                    hasInverse = true;
                    break;
                }
            }
            if (!hasInverse) {
                return false;
            }
        }
        return true;
    }

    public boolean isGroup() {
        return isClosedUnderOperation() && isAssociative() && getIdentityElement() != null && hasInverseElement();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> elements = new HashSet<>();
        System.out.println("Enter the elements of the group (type 'done' to finish):");
        while (scanner.hasNextInt()) {
            elements.add(scanner.nextInt());
        }
        scanner.next(); // To consume the 'done' or invalid input
        Group group = new Group(elements);
        if (group.isGroup()) {
            System.out.println("The set forms a group under addition.");
        } else {
            System.out.println("The set does not form a group under addition.");
        }
        scanner.close();
    }
}
