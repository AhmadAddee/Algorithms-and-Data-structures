package com.example.algo_0.f4;

import com.example.algo_0.f3.PostfixEvaluator_2023;

public class Main {
    public static void main(String[] args) throws InfixToPostfixParens_2023.SyntaxErrorException {

        /*****
         * @Test
         * CircleArrayQueue
         * NB 8
         */

        CircleArrayQueue_2023<String> nameQ = new CircleArrayQueue_2023<>(10);
        for (int i = 0; i < 8; i++)
            nameQ.offer("e" + (i + 1));
        nameQ.poll();
        nameQ.poll();
        for (int i = 8; i < 14; i++)
            nameQ.offer("e" + (i + 1));
        while (nameQ.peek() != null)
            System.out.println(nameQ.poll());


        /*****
         * @Test
         * ArrayQueue
         * NB 8.1
         */
        /*
        ArrayQueue_2023<String> queue = new ArrayQueue_2023<>(4);
        for (int i = 0; i < 6; i++) {
            queue.offer("e" + (i + 1));
            System.out.println("**********************************" + (i + 1));
            System.out.println(queue.toString());
        }

        System.out.println("**********************************");
        System.out.println(queue.toString());

        queue.poll();
        queue.poll();
        System.out.println(queue.peek());
        queue.offer("e" + 13);
        queue.offer("e" + 14);
        System.out.println("********************************** 15");
        System.out.println(queue.toString());
        queue.offer("e" + 15);
        queue.offer("e" + 16);
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        for (int i = 0; i < 14; i++)
            System.out.println(queue.poll());
*/

        /*****
         * @Test
         * LinkedListQueue_2023
         * NB 9
         */
        /*
        LinkedListQueue_2023<String> queue = new LinkedListQueue_2023<>();

        for (int i = 0; i < 5; i++) {
            //System.out.println("Adding " + (i + 1));
            queue.enqueue("Element " + (i + 1));
        }
        for (int j = 0; j < 5; j++)
            System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
         */


        /*****
         * @Test
         * Dequeue_2023
         * NB 10
         */
        /*
        Dequeue_2023<String> stringDequeue = new Dequeue_2023<>();
        stringDequeue.offerFirst("e2");
        stringDequeue.offerFirst("e1");
        stringDequeue.offerLast("e3");
        stringDequeue.offerLast("e4");

        while (!stringDequeue.empty())
            System.out.println(stringDequeue.pollFirst());
         */

        /*****
         * @Test
         * InfixToPostfixParens_2023
         * NB 7.2
         */
        InfixToPostfixParens_2023 infix = new InfixToPostfixParens_2023();
        System.out.println(infix.convert("(2 - (3 -1)) * (4 + 3)"));
        try {
            System.out.println(infix.solveIntFix());
        } catch (PostfixEvaluator_2023.SyntaxErrorException e) {
            e.printStackTrace();
        }


    }

}
