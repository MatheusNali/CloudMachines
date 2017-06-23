package com.cloudmachines.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class ROI implements Runnable {

	public ROI() {

	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {

		}
	}
}

class OnDemand implements Runnable {

	public OnDemand() {

	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {

		}
	}

}

class DefineCost implements Runnable {

	public DefineCost() {

	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {

		}
	}

}

public class ThreadMaster {
	ExecutorService execService;
	static ArrayList<Future> Futures;
	static Logging Log;
	ArrayList<Logging> ArrLog;
	int iDCliente = 42;
	int ID = 0;
	int maxThread = 5;
	int par_nMaq = 0;

	public ThreadMaster() {
		execService = Executors.newFixedThreadPool(maxThread);
		Futures = new ArrayList<Future>();
		ArrLog = new ArrayList<Logging>();
		Log = new Logging();
	}

	public void ROI(int nMaq) {
		
		for (int i = 0; i < nMaq; i++) {
			if (par_nMaq<get_maxThread()){
				PreencheLog(Log, iDCliente);
				Futures.add(execService.submit(new ROI()));
				Log.setPolicy(1, ID);
				ArrLog.add(Log);
				ID++;
			}
			else{
				i=nMaq;
				VerLogController.LogWarn("A alocacao de maquinas nao pode ser completada");
			}
		}
	}

	public void OnDemand(int nMaq) {
		for (int i = 0; i < nMaq; i++) {
			if (par_nMaq<get_maxThread()){
				PreencheLog(Log, iDCliente);
				Futures.add(execService.submit(new OnDemand()));
				Log.setPolicy(2, ID);
				ArrLog.add(Log);
				ID++;
			}
			else{
				i=nMaq;
				VerLogController.LogWarn("A alocacao de maquinas nao pode ser completada");
			}
		}
	}

	public void DefineCost(int nMaq) {
		for (int i = 0; i < nMaq; i++) {
			if (par_nMaq<get_maxThread()){
				PreencheLog(Log, iDCliente);
				Futures.add(execService.submit(new DefineCost()));
				Log.setPolicy(3, ID);
				ArrLog.add(Log);
				ID++;
			}
			else{
				i=nMaq;
				VerLogController.LogWarn("A alocacao de maquinas nao pode ser completada");
			}
		}
	}
	
	public Logging getLog(){
		return Log;
	}
	
	public int get_maxThread(){
		par_nMaq++;
		return maxThread;
	}

	private void PreencheLog(Logging Log, int iDCliente) {
		Log.setDataIni(new Date());
		Log.setEstado(1);
		Log.setIDCliente(iDCliente);
		
	}
	
	private ArrayList<Future> getFutures(){
		return Futures;
	}
	
	private ArrayList<Logging> getArrLog(){
		return ArrLog;
	}
}
