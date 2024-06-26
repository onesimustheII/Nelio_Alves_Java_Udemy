package secao19_generics_set_map.genericosDelimitados.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import secao19_generics_set_map.genericosDelimitados.entities.Product;
import secao19_generics_set_map.genericosDelimitados.services.CalculationService;

public class Program
{
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		List<Product> list = new ArrayList<>();

		String path = "D:\\temp\\in.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				list.add(new Product(fields[0], Double.parseDouble(fields[1])));
				line = br.readLine();
			}

			Product x = CalculationService.max(list);
			System.out.println("Most expensive:");
			System.out.println(x);

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
