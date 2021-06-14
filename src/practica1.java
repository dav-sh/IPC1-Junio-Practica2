import java.util.*;
public class practica1 {
    public static void main(String[] args){
        practica1 p1 = new practica1();
    }
    Scanner scanner = new Scanner(System.in);
    int customer_Id =0;
    int movies_Id =0;
    String[]category = {"Action","Comedy","Family","Romance","Mystery"};
    //Contructor
    public practica1() {
        // customers
        
        String[] customersNames = new String[30];
        int [] customersId = new int[30];
        int [] customersPhone = new int[30];
        boolean[] customerRentMovies = new boolean[30];
        //movies
        int[] moviesId = new int[30];
        String[] moviesName = new String[30];
        int[] movieYear = new int[30];
        String[] moviesCategory = new String[30];
        boolean[] movieAvailable = new boolean[30];
        //rent of movies
        int[] moviesIdrent = new int[30];
        int[] customersIdrent = new int[30];
        int[] daysRent = new int[30];
        menu(customersNames,customersId,customersPhone,customerRentMovies,moviesId,moviesName,movieYear,moviesCategory,movieAvailable,moviesIdrent,customersIdrent,daysRent);
        
    }
    public void menu(String[] customersNames, int[] customersId, int[] customersPhone,boolean[] customerRentMovies,int[]moviesId, String[]moviesName, int[]movieYear,String[]moviesCategory,boolean[]movieAvailable,int[]moviesIdrent, int[]customersIdrent, int[]daysRent) {
        int option = 0;
        do{
            System.out.println("**********************");
            System.out.println("       Main Menu      ");
            System.out.println("**********************");
            System.out.println("1. Rent a movie");
            System.out.println("2. Return a movie");
            System.out.println("3. See movies");
            System.out.println("4. Add a new movie");
            System.out.println("5. Order the movies");
            System.out.println("6. Add a new Customer");
            System.out.println("7. See Customers");
            System.out.println("8. Report");
            System.out.println("9. Exit");
            System.out.println("**********************");
            System.out.print("  Enter the option: ");
            option = scanner.nextInt();
            if(option==1){
                customerRentMovie(customersNames, customersId, customersPhone, customerRentMovies,moviesId, moviesName, movieYear, moviesCategory,movieAvailable,moviesIdrent,customersIdrent,daysRent);

            }else if(option==2){
                returnMovie(customersNames, customersId, customersPhone, customerRentMovies,moviesId, moviesName, movieYear, moviesCategory,movieAvailable,moviesIdrent,customersIdrent,daysRent);
                
            }else if(option==3){
                seeMovies(moviesId, moviesName, movieYear, moviesCategory,movieAvailable);
                
            }else if(option==4){
                enterMovie(moviesId, moviesName, movieYear, moviesCategory,movieAvailable);
                
            }else if(option==5){
                sortMovies(moviesName, moviesId,  movieYear,  moviesCategory,  movieAvailable );

            }else if(option==6){

                addNewCustomer(customersNames, customersId, customersPhone, customerRentMovies);
            }else if(option==7){

                seeCustomers(customersNames, customersId, customersPhone, customerRentMovies);
            }else if(option==8){

                report(customersNames, customersId, customersPhone, customerRentMovies,moviesId, moviesName, movieYear, moviesCategory,movieAvailable,moviesIdrent,customersIdrent,daysRent);
            }else if(option==9){
                System.out.println(" Exiting ...");
            }else{
                System.out.println("Wrong Option... Try again ");
            }

        }while(option!=9);
    }
    //method enter a new movie
    public void enterMovie(int[] moviesId, String[]moviesName, int[]movieYear, String[]moviesCategory,boolean[] movieAvailable){
        System.out.println("********************************");
        System.out.print("Enter the name of the movie: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.print("Enter the year of the movie: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the category of the movie ");
        System.out.println(" 1. Action");
        System.out.println(" 2. Comedy");
        System.out.println(" 3. Family");
        System.out.println(" 4. Romance ");
        System.out.println(" 5. Mystery ");
        System.out.print(" Enter the option: ");
        //here add changes
        int opCategory = scanner.nextInt();
        for (int i = 0;i<moviesName.length;i++){
            if(moviesName[i] == null){
                movies_Id++; //movie counter
                moviesName[i] = name;  //assign name
                moviesId[i] = movies_Id; //assign id
                movieAvailable[i] = true; //assign available
                movieYear[i] = year; //assign year
                //assign category
                if(opCategory==1){
                    moviesCategory[i]=category[opCategory-1];  //Action

                }else if(opCategory==2){
                    moviesCategory[i]=category[opCategory-1];  //Comedy
                    
                }else if(opCategory==3){
                    moviesCategory[i]=category[opCategory-1];  //Family
                    
                }else if(opCategory==4){
                    moviesCategory[i]=category[opCategory-1];  //Romance
                    
                }else if(opCategory==5){
                    moviesCategory[i]=category[opCategory-1];  //Mystery
                    
                }
                System.out.println("Succesfull ....");
                break;
            }
            //System.out.println(" --------- Error ----------  ");

        }System.out.println("\n");
    }
    //method to see movies 
    public void seeMovies(int[] moviesId, String[]moviesName, int[]movieYear, String[]moviesCategory,boolean[] movieAvailable){
        System.out.println("*****************************************************************************************");
        System.out.println(" Id           Name                   Year                Category              Available");
        System.out.println("*****************************************************************************************");
        for(int i=0;i<moviesName.length;i++){
            if(moviesName[i] != null){
                System.out.printf("%2d            %-15s        %-4d                 %-10s            %-5s%n",moviesId[i],moviesName[i],movieYear[i],moviesCategory[i],movieAvailable[i]);
            }
            else{
                break;
            }
        }
        System.out.println("*****************************************************************************************");

    }
    //method to add new customers
    public void addNewCustomer(String[]customersNames,int[] customersId,int[] customersPhone,boolean[] customerRentMovies){
        System.out.println("********************************");
        System.out.print("Enter the customer's name: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.print("Enter the customer's phone: ");
        int phone = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0;i<customersNames.length;i++){
            if(customersNames[i] == null){
                customer_Id++; //customer counter
                customersNames[i] = name;  //assign name
                customersId[i] = customer_Id; //assign id
                customerRentMovies[i] = false; //assign available
                customersPhone[i]=phone;  //add phone number
                System.out.println("Succesfull ....");
                break;
            }
            //System.out.println(" --------- Error ----------  ");

        }System.out.println("\n");
    }
    //method to see customers
    public void seeCustomers(String[]customersNames,int[] customersId,int[] customersPhone,boolean[] customerRentMovies){
        System.out.println("*****************************************************************************************");
        System.out.println(" Id           Name                            Phone                  Rent-Movie          ");
        System.out.println("*****************************************************************************************");
        for(int i=0;i<customersNames.length;i++){
            if(customersNames[i] != null){
                System.out.printf("%2d            %-30s  %-10d                %-5s%n",customersId[i],customersNames[i],customersPhone[i],customerRentMovies[i]);
            }
            else{
                break;
            }
        }
        System.out.println("*****************************************************************************************");
    }

    //method to rent a movie
    public void customerRentMovie(String[]customersNames,int[] customersId,int[] customersPhone,boolean[] customerRentMovies,int[] moviesId, String[]moviesName, int[]movieYear, String[]moviesCategory,boolean[] movieAvailable, int[]moviesIdrent, int[]customersIdrent, int[]daysRent){
        int option = 0;
        do{
            System.out.println("********************************");
            System.out.println("1. see available movies");
            System.out.println("2. rent a movie");
            System.out.println("3. return");
            System.out.println("********************************");
            System.out.print(" Option: ");
            option = scanner.nextInt();
            if(option ==1){

                avialableMovies(moviesId, moviesName, movieYear, moviesCategory,movieAvailable);
            }else if(option==2){

                //selectMovietoRent(customersNames, customersId, customersPhone, customerRentMovies,moviesId, moviesName, movieYear, moviesCategory,movieAvailable,moviesIdrent,customersIdrent,daysRent);
                selectMovietoRent(customersId, customerRentMovies, customersNames, movieAvailable,moviesIdrent,customersIdrent,daysRent);
            }else if(option==3){
                System.out.println("Returning ...");
            }else{
                System.out.println("Wrong option");
            }

        }while(option!=3);

    }
    //method to print available movie 
    public void avialableMovies(int[] moviesId, String[]moviesName, int[]movieYear, String[]moviesCategory,boolean[] movieAvailable){
        System.out.println("*****************************************************************************************");
        System.out.println("*****************************   Avialable Movies   **************************************");
        System.out.println("*****************************************************************************************");
        System.out.println(" Id           Name                   Year                Category              Available");
        System.out.println("*****************************************************************************************");
        for(int i=0;i<moviesName.length;i++){
            if(movieAvailable[i] == true){
                System.out.printf("%-2d            %-15s       %-4d                  %-10s            %-5s%n",moviesId[i],moviesName[i],movieYear[i],moviesCategory[i],movieAvailable[i]);
            }
            else if(moviesName[i] == null){
                break;
            }
        }
        System.out.println("*****************************************************************************************");
    }

    //method to select a movie for rent
    public void selectMovietoRent(int[] customersId, boolean[] customerRentMovies, String[]customersNames,boolean[]movieAvailable,int[] moviesIdrent, int[] customersIdrent,int[] daysRent ){
        System.out.println("Enter the movie id: ");
        int idMovie = scanner.nextInt();
        System.out.println("Enter the customer id: ");
        int idCustomer = scanner.nextInt();
        System.out.print("Enter the numbers of days: ");
        int days = scanner.nextInt();
        scanner.nextLine();
        if(((movieAvailable[idMovie-1] ==true) && (customerRentMovies[idCustomer-1]==false)) && customersId[idCustomer-1]!=0){
            System.out.println("Are you sure to rent this movie? (Y/N ) ");
            String option = scanner.nextLine();
            if(option.equalsIgnoreCase("y")){
                movieAvailable[idMovie-1] = false; //change available movie to false    
                customerRentMovies[idCustomer-1]=true; //change available customer rent to true
                for(int i=0;i<customersIdrent.length;i++){
                    if(customersIdrent[i]==0){
                        moviesIdrent[i] = idMovie;
                        customersIdrent[i]= idCustomer;
                        daysRent[i]=days;
                        break;
                    }
                }
                
                System.out.println("Succesfull...");
            }
        }

    }

    //method for return a movie
    //method to return a movie
    public void returnMovie(String[]customersNames,int[] customersId,int[] customersPhone,boolean[] customerRentMovies,int[] moviesId, String[]moviesName, int[]movieYear, String[]moviesCategory,boolean[] movieAvailable, int[]moviesIdrent, int[]customersIdrent, int[]daysRent){
        int option = 0;
        do{
            System.out.println("********************************");
            System.out.println("1. see rented movies");
            System.out.println("2. return a rented movie");
            System.out.println("3. return");
            System.out.println("********************************");
            System.out.print(" Option: ");
            option = scanner.nextInt();
            if(option ==1){

                rentedMovies(moviesId, moviesIdrent, moviesName, movieAvailable, customersIdrent, customersNames, customersId,customerRentMovies, daysRent);
               // rentedMovies(moviesId, moviesName, movieYear, moviesCategory,movieAvailable, customersId, customersNames, customerRentMovies);

            }else if(option==2){

                selectMovietoReturn(customersId, customerRentMovies, customersNames, movieAvailable,moviesIdrent,customersIdrent,daysRent,moviesName);
            }else if(option==3){
                System.out.println("Returning ...");
            }else{
                System.out.println("Wrong option");
            }

        }while(option!=3);

    }
    //method to print not available movie 
    public void rentedMovies(int[]moviesId, int[] moviesIdrent, String[]moviesName, boolean[] movieAvailable, int []customersIdrent, String[]customersNames, int[]customersId,boolean[] customerRentMovies, int[] daysRent){
        System.out.println("*****************************************************************************************");
        System.out.println("*******************************   Rented Movies   ***************************************");
        System.out.println("*****************************************************************************************");
        System.out.println(" Id-Movie     Name-Movie            Id-Customer       Customer            days-Rented    "); //i need to modify this to write the name and id of customer
        System.out.println("*****************************************************************************************");
        for(int i=0;i<moviesName.length;i++){
            if(movieAvailable[i] != true && moviesName[i] != null && customersNames[i]!=null){
                System.out.printf(" %-2d           %-15s       %-2d                 %-30s %-4d%n",moviesId[i],moviesName[i],customersId[i],customersNames[i],daysRent[i]);
            }
            else if(moviesName[i] == null){
                break;
            }
        }
        System.out.println("*****************************************************************************************");
    }

    //method to select a movie for return
    public void selectMovietoReturn(int[] customersId, boolean[] customerRentMovies, String[]customersNames,boolean[]movieAvailable,int[] moviesIdrent, int[] customersIdrent,int[] daysRent, String[]moviesName  ){
        System.out.println("Enter the movie id: ");
        int idMovie = scanner.nextInt();
        System.out.println("Enter the customer id: ");
        int idCustomer = scanner.nextInt();
        scanner.nextLine();
        if((movieAvailable[idMovie-1] !=true) && (customerRentMovies[idCustomer-1]!=false)&& moviesName[idMovie-1] != null && customersNames[idCustomer-1]!=null){
            System.out.println("Are you sure to return this movie? (Y/N ) ");
            String option = scanner.nextLine();
            if(option.equalsIgnoreCase("y")){
                movieAvailable[idMovie-1] = true; //change available movie to true    
                customerRentMovies[idCustomer-1]=false; //change available customer rent to false
                System.out.println("Succesfull...");
            }
        }

    }
    //method to sort the lists



    //method to generate reports
    public void report(String[]customersNames,int[] customersId,int[] customersPhone,boolean[] customerRentMovies,int[] moviesId, String[]moviesName, int[]movieYear, String[]moviesCategory,boolean[] movieAvailable, int[]moviesIdrent, int[]customersIdrent, int[]daysRent){
        int option = 0;
        do{
            System.out.println("********************************");
            System.out.println("1. see movie numbers by category");
            System.out.println("2. search by category");
            System.out.println("3. Report movies");
            System.out.println("4. most rented movie ");
            System.out.println("5. least rented movie ");
            System.out.println("6. return");
            System.out.println("********************************");
            System.out.print(" Option: ");
            option = scanner.nextInt();
            if(option ==1){
                categoryMovies(moviesId, moviesIdrent, moviesName, movieAvailable, customersIdrent, customersNames, customersId,customerRentMovies, daysRent,moviesCategory);

            }else if(option==2){

                searchCategory(moviesId, moviesIdrent, moviesName, movieAvailable, customersIdrent, customersNames, customersId,customerRentMovies, daysRent,moviesCategory);
            }else if(option==3){
                reportMovies(moviesIdrent,moviesName,movieAvailable,moviesId);
            }
            else if(option==4){
                mostRented(moviesIdrent,moviesName,movieAvailable,moviesId);
            }
            else if(option==5){
                leastRented(moviesIdrent,moviesName,movieAvailable,moviesId);
            }
            else if(option==6){
                System.out.println("Returning ...");
            }
            else{
                System.out.println("Wrong option");
            }

        }while(option!=6);



    }
    public void categoryMovies(int[]moviesId,int[] moviesIdrent, String[]moviesName, boolean[]movieAvailable, int[]customersIdrent, String[]customersNames, int[]customersId,boolean[]customerRentMovies, int[]daysRent,String[] moviesCategory){
        System.out.println("*****************************************************************************************");
        System.out.println("*******************************  Number of Movies  **************************************");
        System.out.println("*****************************************************************************************");
        System.out.println(" Action           Comedy              Family          Romance              Mystery       "); //i need to modify this to write the name and id of customer
        System.out.println("*****************************************************************************************\n");
        int action =0;
        int comedy =0;
        int family=0;
        int romance=0;
        int mystery=0;
        for(int i=0;i<moviesName.length;i++){
            if(moviesName[i]!=null){
                        //Action
                if(moviesCategory[i].equals("Action")){
                    action++;
                }else if(moviesCategory[i].equals("Comedy")){
                    comedy++;
                }else if(moviesCategory[i].equals("Family")){
                    family++;
                }else if(moviesCategory[i].equals("Romance")){
                    romance++;
                }else if(moviesCategory[i].equals("Mystery")){
                    mystery++;
                    
                }
            }
                // System.out.println("*****************************************************************************************");
            else if(moviesName[i] == null){
                break;
            }
        } 
        System.out.printf("   %-2d              %-2d                    %-2d             %-2d                  %-2d%n%n",action,comedy,family,romance,mystery);
        System.out.println("*****************************************************************************************");
    }


    public void searchCategory(int[]moviesId,int[] moviesIdrent, String[]moviesName, boolean[]movieAvailable, int[]customersIdrent, String[]customersNames, int[]customersId,boolean[]customerRentMovies, int[]daysRent,String[] moviesCategory){
        //String[]movies = new String[30];
        int[]id=new int[30];
        System.out.println("*****************************************************************************************");
        System.out.println("************************************  Movies  *******************************************");
        System.out.println("*****************************************************************************************");
        System.out.println(" Categories ");
        System.out.println(" 1. Action");
        System.out.println(" 2. Comedy");
        System.out.println(" 3. Family");
        System.out.println(" 4. Romance ");
        System.out.println(" 5. Mystery ");
        System.out.print(" Enter the option: ");
        int opCategory = scanner.nextInt();
        System.out.println("*****************************************************************************************");
        String[]movies=movies(opCategory,moviesName,moviesCategory);
        int[]idmovies=idmovies(opCategory,moviesName,moviesCategory,moviesId);
        System.out.println("  Id-Movie              Name-Movie");
        System.out.println("*****************************************************************************************");
        for(int i=0;i<movies.length;i++){
            if(movies[i]!=null){
                System.out.printf(" %-2d                    %-15s%n",idmovies[i],movies[i]);
            }
        }
        System.out.println("*****************************************************************************************");
    }

    public String[] movies(int opCategory, String[]moviesName,String[]moviesCategory){
        String[]options={"Action","Comedy","Family","Romance","Mystery"};
        String[]movies=new String[30];
        String option=options[opCategory-1];
        for(int i=0;i<moviesName.length;i++){
                if(moviesName[i] != null){
                        if(moviesCategory[i].equals(option)){
                            movies[i]=moviesName[i];
                            //id[i]=moviesId[i];
                        }
                }
                else if(moviesName[i] == null){
                    break;
                }
            }
        return movies;
    }

    public int[] idmovies(int opCategory, String[]moviesName,String[]moviesCategory,int[]moviesId){
        String[]options={"Action","Comedy","Family","Romance","Mystery"};
        int[]id=new int[30];
        String option=options[opCategory-1];
        for(int i=0;i<moviesName.length;i++){
                if(moviesName[i] != null){
                        if(moviesCategory[i].equals(option)){
                            //movies[i]=moviesName[i];
                            id[i]=moviesId[i];
                        }
                }
                else if(moviesName[i] == null){
                    break;
                }
            }
        return id;
    }

    public void reportMovies(int[] moviesIdrent,String[]moviesName,boolean[]movieAvailable,int[]moviesId){
        //int counter = 0;
        System.out.println("*****************************************************************************************");
        System.out.println("                                      Reports                                            ");
        System.out.println("*****************************************************************************************");
        for(int i=0;i<moviesName.length;i++){
            if(moviesName[i]!=null){
                String aux = moviesName[i];
                int aux2 = moviesId[i];
                int countAux=0;
                for(int j=0;j<moviesIdrent.length;j++){
                    if(moviesIdrent[j]!=0 && moviesIdrent[j]==aux2){
                        countAux++;
                        //System.out.println(" #: "+countAux);
                    }
                
                }
                System.out.printf(" %-15s           #Rented: %-2d%n",aux,countAux);

                
            }
        }
        System.out.println("*****************************************************************************************");
    }
    public void mostRented(int[] moviesIdrent,String[]moviesName,boolean[]movieAvailable,int[]moviesId){
         int[] counter=new int[30];
        String[]name=new String[30];
        System.out.println("*****************************************************************************************");
        System.out.println("                                Most Movie Rented                                        ");
        System.out.println("*****************************************************************************************");
        for(int i=0;i<moviesName.length;i++){
            if(moviesName[i]!=null){
                String aux = moviesName[i];
                int aux2 = moviesId[i];
                int countAux=0;
                for(int j=0;j<moviesIdrent.length;j++){
                    if(moviesIdrent[j]!=0 && moviesIdrent[j]==aux2){
                        countAux++;
                        //System.out.println(" #: "+countAux);
                    }
                }
                counter[i]=countAux;
                name[i]=aux;
            }
        }
        int less=counter[0];
        String movie=name[0];
        for(int i=0;i<counter.length;i++){
            if(name[i]!=null){
                if(less<=counter[i]){  //critical 
                    less = counter[i];
                    movie = name[i];
                }
            
            }else{
                break;
            }
        }
        if(movie!=null){
            System.out.printf(" %-15s                          #Rented: %-2d%n",movie,less);
        }
        System.out.println("*****************************************************************************************");
    }






    public void leastRented(int[] moviesIdrent,String[]moviesName,boolean[]movieAvailable,int[]moviesId){
        int[] counter=new int[30];
        String[]name=new String[30];
        System.out.println("*****************************************************************************************");
        System.out.println("                                Least Movie Rented                                       ");
        System.out.println("*****************************************************************************************");
        for(int i=0;i<moviesName.length;i++){
            if(moviesName[i]!=null){
                String aux = moviesName[i];
                int aux2 = moviesId[i];
                int countAux=0;
                for(int j=0;j<moviesIdrent.length;j++){
                    if(moviesIdrent[j]!=0 && moviesIdrent[j]==aux2){
                        countAux++;
                        //System.out.println(" #: "+countAux);
                    }
                }
                counter[i]=countAux;
                name[i]=aux;
            }
        }
        int less=counter[0];
        String movie=name[0];
        for(int i=0;i<counter.length;i++){
            if(name[i]!=null){
                if(less>=counter[i]){  //critical
                    less = counter[i];
                    movie = name[i];
                }
            
            }else{
                break;
            }
        }
        if(movie!=null){
            System.out.printf(" %-15s                          #Rented: %-2d%n",movie,less);
        }
        System.out.println("*****************************************************************************************");
    }

    //sort the list of movies
    public void sortMovies(String[]moviesName, int[] moviesId, int[] movieYear, String[] moviesCategory, boolean[] movieAvailable ){
        System.out.println("*****************************************************************************************");
        System.out.println("Procesing ...");
        // System.out.println("Posición " + 0 + ": " + moviesName[0]);
        // System.out.println("Posición " + 1 + ": " + moviesName[1]);

        String selec = moviesName[0];
        int pos = 0;

        //modify
        int id = moviesId[0];
        int year = movieYear[0];
        String category = moviesCategory[0];
        boolean available = movieAvailable[0];

        // int operaciones = 0;
        // int intercambio = 0;

        for (int i = 0; i < moviesName.length; i++) {
            selec = moviesName[i];
            pos = i;
            id = i;

            //modify
            id = moviesId[i];
            year = movieYear[i];
            category = moviesCategory[i];
            available = movieAvailable[i];

            for (int j = i+1; j < moviesName.length; j++) {
                if(moviesName[j]!=null && selec !=null){
                    if (selec.compareTo(moviesName[j])>0){
                        selec = moviesName[j];
                        pos = j;
                        //modify
                        id = moviesId[j];
                        year = movieYear[j];
                        category = moviesCategory[j];
                        available = movieAvailable[j];
                    }

                }
                // operaciones++;
            }


            moviesName[pos] = moviesName[i];
            moviesName[i] = selec;
            // intercambio++;

            //modify
            moviesId[pos]=moviesId[i];
            moviesId[i]=id;

            movieYear[pos]=movieYear[i];
            movieYear[i]=year;

            moviesCategory[pos]=moviesCategory[i];
            moviesCategory[i]=category;

            movieAvailable[pos]=movieAvailable[i];
            movieAvailable[i]=available;



            
        }
        // System.out.println("Operaciones: "+operaciones + " Intercambios "+intercambio);
        // for (int i = 0; i < moviesName.length; i++) {
        //     System.out.println("Posición " + i + ": " + moviesName[i]);
        // }
    
        System.out.println("Succesfull ...");

    
    }

    
    public void imprimirMatriz(int[] array) {
        
    }
    








}
