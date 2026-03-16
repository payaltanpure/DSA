class Array1 {

    public static void main(String[] args) {

        int arr[7] = {10, 45, 23, 67, 12, 89, 34};

        int largest = arr[0];   // assume first element is largest

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] > largest) {
                largest = arr[i];
            }
        }

        System.out.println("Largest element in array: " + largest);
    }
}