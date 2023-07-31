public class Main {
    public static void main(String[] args) {
        OnTaskDoneListener listener = System.out::println;
        OnTaskErrorListener errorListener = System.out::println;

        Worker worker = new Worker(listener, errorListener);
        worker.start();
    }
}

class Worker{
    OnTaskDoneListener callback;
    OnTaskErrorListener errorCallback;
    public Worker(OnTaskDoneListener callback){
        this.callback = callback;

    }

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback){
        this.callback = callback;
        this.errorCallback = errorCallback;
    }


    public void start() {
        for (int i = 0; i < 100; i++) {
            if(i==33){
                errorCallback.onError("\n !!!!!! -- Task " + i + " is in a error --- !!!!!!! \n");
            }else{
                callback.onDone("Task " + i + " is done");
            }
        }
    }

}

