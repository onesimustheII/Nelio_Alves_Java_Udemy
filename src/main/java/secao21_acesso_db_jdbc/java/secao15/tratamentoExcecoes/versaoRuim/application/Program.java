package secao15.tratamentoExcecoes.versaoRuim.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import secao15.tratamentoExcecoes.versaoRuim.entities.Reservation;

	/*
	Problema exemplo

	Fazer um programa para ler os dados de uma reserva de hotel (número do quarto, data
	de entrada e data de saída) e mostrar os dados da reserva, inclusive sua duração em
	dias. Em seguida, ler novas datas de entrada e saída, atualizar a reserva, e mostrar
	novamente a reserva com os dados atualizados. O programa não deve aceitar dados
	inválidos para a reserva, conforme as seguintes regras:

	- Alterações de reserva só podem ocorrer para datas futuras
	- A data de saída deve ser maior que a data de entrada
	 */

	/*
	Resumo da Aula

	Solução 2 (ruim): método retornando string

		• A semântica da operação é prejudicada
		• Retornar string não tem nada a ver com atualização de reserva
		• E se a operação tivesse que retornar um string?
		• Ainda não é possível tratar exceções em construtores
		• Ainda não há auxílio do compilador: o programador deve "lembrar" de verificar se houve
		  erro
		• A lógica fica estruturada em condicionais aninhadas
	 */

public class Program
{
	public static void main(String[] args) throws ParseException
	{
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn))
		{
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else
		{
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			String error = reservation.updateDates(checkIn, checkOut);
			if (error != null)
			{
				System.out.println("Error in reservation: " + error);
			}
			else
			{
				System.out.println("Reservation: " + reservation);
			}
		}
		sc.close();
	}

}
