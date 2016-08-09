package com.annesophie.test_decat;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/* Classe pour utiliser Retrofit */

public class DataDecat {

    private Retrofit retrofit;
    private GitHubService service;

    public DataDecat()  {

        retrofit = new Retrofit.Builder()
                .baseUrl("https://dktmobile.oxylane.com/backofficemobile-server-mvc/service/stores")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(GitHubService.class);
    }

    public void getNameStoreDecat() {

        /*

            Code avec la méthode enqueue
            Testé avec Call <List<Data>>
            Testé avec Call <Data>
            Testé avec Call <Store>

         */

        //Call <List<Data>> call = service.groupListNameDecat();
        /* call.enqueue(new Callback <List<Data>>() {
            @Override
            public void onResponse(Call <List<Data>> call, Response <List<Data>> response) {

                System.out.println(response.code());
            }

            @Override
            public void onFailure(Call <List<Data>> call, Throwable t) {

            }
        }); */

        /*

            Code avec la méthode execute

         */

        /* Thread thread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    Call <ArrayList<Data>> call = service.groupListNameDecat();
                    System.out.println("ICI" + call.execute().body());
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });

        thread.start(); */
    }

}
