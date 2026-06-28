class FrequencyArray {

    public static void main(String[] args) {

        int[] arr = { 10, 20, 10, 30, 20, 10 };
        int n = arr.length;

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {

            if (visited[i] == true)
            {
                   continue;
            }
             

            int count = 1;

            for (int j = i + 1; j < n; j++) {

                if (arr[i] == arr[j]) {
                    count++;
                    visited[j] = true;
                }
            }

            System.out.println(arr[i] + " occurs " + count + " times");
        }
    }
}