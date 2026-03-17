import java.util.Scanner;

class Array3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[n] = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        int position = -1;

        for (int i = 0; i < n; i++) {

            if (arr[i] == key) {
                position = i;
                break;
            }
        }

        if (position != -1) {
            System.out.println("Element found at position: " + (position + 1));
        } else {
            System.out.println("Element not found");
        }

        sc.close();
    }
}