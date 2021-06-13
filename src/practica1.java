import java.util.*;
public class practica1 {
    public static void main(String[] args){
        practica1 p1 = new practica1();
    }
    Scanner scanner = new Scanner(System.in);
    int customer_Id =0;
    int movies_Id =0;
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
                // orderMovies();

            }else if(option==6){

                addNewCustomer(customersNames, customersId, customersPhone, customerRentMovies);
            }else if(option==7){

                seeCustomers(customersNames, customersId, customersPhone, customerRentMovies);
            }else if(option==8){

                // report();
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
        System.out.print("Enter the category of the movie: ");
        String category = scanner.nextLine();
        for (int i = 0;i<moviesName.length;i++){
            if(moviesName[i] == null){
                movies_Id++; //movie counter
                moviesName[i] = name;  //assign name
                moviesId[i] = movies_Id; //assign id
                movieAvailable[i] = true; //assign available
                moviesCategory[i]=category;  //assign category
                movieYear[i] = year; //assign year
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
                System.out.printf("%2d            %-15s       %4d                  %-10s            %-5s%n",moviesId[i],moviesName[i],movieYear[i],moviesCategory[i],movieAvailable[i]);
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
        System.out.println(" Id           Name                              Phone                Rent-Movie          ");
        System.out.println("*****************************************************************************************");
        for(int i=0;i<customersNames.length;i++){
            if(customersNames[i] != null){
                System.out.printf("%2d            %-30s  %10d                %-5s%n",customersId[i],customersNames[i],customersPhone[i],customerRentMovies[i]);
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
                System.out.printf("%2d            %-15s       %-4d                  %-10s            %-5s%n",moviesId[i],moviesName[i],movieYear[i],moviesCategory[i],movieAvailable[i]);
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
        if((movieAvailable[idMovie] ==true) && (customerRentMovies[idCustomer]==false)){
            System.out.println("Are you sure to rent this movie? (Y/N ) ");
            String option = scanner.nextLine();
            if(option.equalsIgnoreCase("y")){
                movieAvailable[idMovie] = false; //change available movie to false    
                customerRentMovies[idCustomer]=true; //change available customer rent to true
                for(int i=0;i<customersIdrent.length;i++){
                    if(customersIdrent[i]==0){
                        moviesIdrent[i] = idMovie;
                        customersIdrent[i]= idCustomer;
                        daysRent[i]=days;
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

                rentedMovies(moviesId, moviesName, movieYear, moviesCategory,movieAvailable, customersId, customersNames, customerRentMovies);
            }else if(option==2){

                selectMovietoReturn(customersId, customerRentMovies, customersNames, movieAvailable,moviesIdrent,customersIdrent,daysRent);
            }else if(option==3){
                System.out.println("Returning ...");
            }else{
                System.out.println("Wrong option");
            }

        }while(option!=3);

    }
    //method to print not available movie 
    public void rentedMovies(int[] moviesId, String[]moviesName, int[]movieYear, String[]moviesCategory,boolean[] movieAvailable, int[]customersId, String[]customersNames,boolean[] customerRentMovies){
        System.out.println("*****************************************************************************************");
        System.out.println("*******************************   Rented Movies   ***************************************");
        System.out.println("*****************************************************************************************");
        System.out.println(" Id           Name                   Year                Category              Rented    "); //i need to modify this to write the name and id of customer
        System.out.println("*****************************************************************************************");
        for(int i=0;i<moviesName.length;i++){
            if(movieAvailable[i] != true && moviesName[i] != null){
                System.out.printf("%2d            %-15s       %-4d                  %-10s            %-5s%n",moviesId[i],moviesName[i],movieYear[i],moviesCategory[i],movieAvailable[i]);
            }
            else if(moviesName[i] == null){
                break;
            }
        }
        System.out.println("*****************************************************************************************");
    }

    //method to select a movie for return
    public void selectMovietoReturn(int[] customersId, boolean[] customerRentMovies, String[]customersNames,boolean[]movieAvailable,int[] moviesIdrent, int[] customersIdrent,int[] daysRent ){
        System.out.println("Enter the movie id: ");
        int idMovie = scanner.nextInt();
        System.out.println("Enter the customer id: ");
        int idCustomer = scanner.nextInt();
        scanner.nextLine();
        if((movieAvailable[idMovie] !=true) && (customerRentMovies[idCustomer]!=false)){
            System.out.println("Are you sure to return this movie? (Y/N ) ");
            String option = scanner.nextLine();
            if(option.equalsIgnoreCase("y")){
                movieAvailable[idMovie] = true; //change available movie to true    
                customerRentMovies[idCustomer]=false; //change available customer rent to false
                System.out.println("Succesfull...");
            }
        }

    }
    








}
