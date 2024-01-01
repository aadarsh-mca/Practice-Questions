public class DuplicateNumber {
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,1};
        // int[] arr = {1,1,1,3,3,4,3,2,4,2};

        System.out.println(containsDuplicate(arr));
    }

    public static boolean containsDuplicate(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            int j = i - 1;

            // Сдвигаем элементы вправо, пока не найдем правильную позицию для текущего элемента.
            // We move the elements to the right until we find the correct position for the current element.
            while (j >= 0 && nums[j] > current) {
                nums[j + 1] = nums[j];
                j--;
            }

            // Если нашли дубликат, возвращаем true.
            // If a duplicate is found, return true.
            if (j >= 0 && nums[j] == current) {
                return true;
            }

            // Вставляем текущий элемент на правильную позицию.
            // Insert the current element at the correct position.
            nums[j + 1] = current;
        }

        // Если после перебора всех элементов дубликаты не найдены, возвращаем false.
        // If after searching through all elements no duplicates are found, return false.
        return false;
    }

}
