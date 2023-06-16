package org.h_w_seminar_2;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {1234, 4, 7, 2, 1, -3, 0, 567, 45, 90, 34,2, 234};

        heapSort(arr);

        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    public static void heapSort(int[] arr) {
        //длина массива
        int n = arr.length;

        //создаём дерево, построение кучи (перегруппируем массив)
        for(int i  = n / 2 - 1; i >= 0; i--)
            heapify(arr, i , n);

        //Делаем сортировку массива, уже отсортированного дерева,
        //Один за другим извлекаем элементы из кучи
        for (int i = n - 1; i >= 0; i--){

            // Перемещаем текущий корень в конец
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(arr, 0, i);
        }

    }

    private static void heapify(int[] arr, int i, int n) {
        //левый ребёнок
        int l = i * 2 + 1;

        //правый ребёнок
        int r = i * 2 + 2;

        int largest = i;

        if(l < n && arr[l] > arr[largest])
            largest = l;

        if(r < n && arr[r] > arr[largest])
            largest = r;

        if (i != largest){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, largest, n);
        }
    }
}