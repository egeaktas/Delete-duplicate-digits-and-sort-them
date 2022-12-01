// This program takes an integer from the user, deletes the duplicate numbers and sorts the remaining numbers in an array.
// For example: Given the input 1990032755, it creates an array which is {0,1,2,3,5,7,9}

// Bu program kullanıcıdan bir tam sayı alır, tekrar eden basamakları siler ve geriye kalan basamakları bir dizide sıralar.
// Örneğin, kullanıcı 1990032755 sayısını girdiğinde {0,1,2,3,5,7,9} dizisini oluşturur.


import java.util.*;
public class Main {

    public static int tekrarEdenleriSil(int a[], int n)
    {
        // Dizinin büyüklüğü 0 ya da 1 ise dizi zaten sıralıdır.
        if (n == 0 || n == 1) {
            return n;
        }

        int j = 0;


        for (int i = 0; i < n - 1; i++) {
            if (a[i] != a[i + 1]) {
                a[j++] = a[i];
            }
        }

        a[j++] = a[n - 1];

        return j;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner (System.in);

        System.out.print("Sayı giriniz: ");
        int number = input.nextInt();

        int number2 = number;

        int basamak_sayisi = 0;
        while(number2 != 0){
            number2 = number2 / 10;
            basamak_sayisi++;
        }

        int array[] = new int[basamak_sayisi];

        for(int i = 0; i < basamak_sayisi; i++){
            array[i] = number%10;
            number = number / 10;
        }

        for (int i = 0; i < array.length; i++)
        {
            for (int j = i + 1; j < array.length; j++)
            {
                int tmp = 0;
                if (array[i] > array[j])
                {
                    tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }

        }

    int n = tekrarEdenleriSil(array, basamak_sayisi);

        for (int i = 0; i < n; i++)
            System.out.print(array[i] + " ");

    }
}