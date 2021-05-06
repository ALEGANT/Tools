package com.ggf.music.base;

import javax.sound.midi.Instrument;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Soundbank;
import javax.sound.midi.Synthesizer;

public class MusicBase {
	public static int flat; // ???,???DeviceManage.flat = index-4;
	// //????????????C????flat=0

	public static Sequencer sequencer;
	public static Sequence sequence;
	public static Synthesizer synthesizer;
	public static Instrument instruments[];

	public static MidiDevice device_left;
	public static MidiDevice device_right;

	public static MidiChannel channel_left; // ????
	public static MidiChannel channel_right;
	public static int channel_index_left = 0; // ?????????index
	public static int channel_index_right = 1;

	public static int program_left; // ???????
	public static int program_right;

	public static int velocity_left = 75; // ??????
	public static int velocity_right = 90; // ??????

	public static int v8_left = 0; // ????
	public static int v8_right = 0; // ????

	public static int delay_left_index;
	public static int delay_right_index;


	private int v1 = 48;
	private int v2 = 50;
	private int v3 = 52;
	private int v4 = 53;
	private int v5 = 55;
	private int v6 = 57;
	private int v7 = 59;
	private int z1 = 60;
	private int z2 = 62;
	private int z3 = 64;
	private int z4 = 65;
	private int z5 = 67;
	private int z6 = 69;
	private int z7 = 71;
	private int u1 = 72;
	private int u2 = 74;
	private int u3 = 76;
	private int u4 = 77;
	private int u5 = 79;
	private int u6 = 81;
	private int u7 = 83;


	public MusicBase() {
		initial();

		// changeProgram(midiDevice_left,10);
		// changeProgram(device_left, channel_index_left, 60);
		// changeProgram(midiDevice_right,channel_right_index,60);
//		prelude();
//		A();
	}

	private void prelude() {
		play(z6, 400);
		play(z6, 400);
		play(z5, 200);
		play(z6, 200);
		play(z6, 400);
		play(z5, 400);
		play(z6, 200);
		play(z6, 200);

		play(z5, 400);
		play(z6, 400);
		play(u2, 400);
		play(z6, 400);
		play(z6, 400);
		play(z5, 400);
		play(z6, 400);
		play(z5, 400);
		play(z5, 400);
		play(z6, 400);
		play(u1, 400);
		play(u2, 400);
		play(u3, 400);

		play(z2, 200);
		play(z3, 200);
		play(v6, 100);
		play(v5, 100);
		play(v6, 100);
		play(v5, 100);

		play(z2, 200);
		play(z3, 200);
		play(v6, 100);
		play(v5, 100);
		play(v6, 100);
		play(v5, 100);

		play(z2, 200);
		play(z3, 200);
		play(v6, 100);
		play(v5, 100);
		play(v6, 100);
		play(v5, 100);

		play(z1, 200);
		play(z7, 200);

		play(v6, 100);
		play(v5, 100);

		play(z2, 200);
		play(z3, 200);
		play(v6, 100);
		play(v5, 100);
		play(v6, 100);
		play(v5, 100);

		play(z2, 200);
		play(z3, 200);
		play(v6, 100);
		play(v5, 100);
		play(v6, 100);
		play(v5, 100);

		play(z2, 100);
		play(z3, 100);
		play(z5, 100);
		play(u1, 100);

		play(z7, 100);
		play(u1, 100);
		play(z7, 100);
		play(z6, 100);

		play(z5, 200);
		play(z3, 200);

		play(z2, 200);
		play(z3, 200);
		play(v6, 100);
		play(v5, 100);
		play(v6, 100);
		play(v5, 100);

		play(z2, 200);
		play(z3, 200);
		play(v6, 100);
		play(v5, 100);
		play(v6, 100);
		play(v5, 100);

		play(z2, 200);
		play(z3, 200);
		play(v6, 100);
		play(v5, 100);
		play(v6, 100);
		play(v5, 100);

		play(z1, 200);
		play(z7, 200);

		play(v6, 100);
		play(v5, 100);

		play(z1, 200);
		play(v6, 100);
		play(z1, 100);

		play(z2, 200);
		play(z2, 100);
		play(z3, 100);

		play(z5, 100);
		play(u1, 100);
		play(z3, 100);
		play(z5, 100);

		play(u1, 100);
		play(z7, 100);
		play(u1, 100);
		play(z7, 100);

		play(z6, 200);
		play(z5, 200);

		play(z6, 400);
		play(z6, 200);
		play(u1, 100);

	}

	private void A() {
		play(u2, 200);
		play(u3, 200);
		play(z6, 100);
		play(z5, 100);
		play(z6, 100);
		play(z5, 100);

		play(u2, 200);
		play(u3, 200);
		play(z6, 100);
		play(z5, 100);
		play(z6, 100);
		play(z5, 100);

		play(u2, 200);
		play(u3, 200);
		play(z6, 100);
		play(z5, 100);
		play(z6, 100);
		play(z5, 100);

		play(u1, 200);
		play(z7, 200);

		play(z6, 100);
		play(z5, 100);

		play(u2, 200);
		play(u3, 200);
		play(z6, 100);
		play(z5, 100);
		play(z6, 100);
		play(z5, 100);

		play(u2, 200);
		play(u3, 200);
		play(z6, 100);
		play(z5, 100);
		play(z6, 100);
		play(z5, 100);

		play(u2, 200);
		play(u3, 200);
		play(u5, 200);
		play(u1, 200);

		play(u7, 100);
		play(u1, 100);
		play(u7, 100);
		play(u6, 100);

		play(u5, 200);
		play(u3, 200);

		play(u2, 200);
		play(u3, 200);
		play(z6, 100);
		play(z5, 100);
		play(z6, 100);
		play(z5, 100);

		play(u2, 200);
		play(u3, 200);
		play(z6, 100);
		play(z5, 100);
		play(z6, 100);
		play(z5, 100);

		play(u2, 200);
		play(u3, 200);
		play(z6, 100);
		play(z5, 100);
		play(z6, 100);
		play(z5, 100);

		play(u1, 200);
		play(z7, 200);

		play(z6, 100);
		play(z5, 100);
	}


	public static void initial() {

		openDevice_left("Microsoft");
		openDevice_right("Microsoft");

		try {
			if (synthesizer == null) {
				if ((synthesizer = MidiSystem.getSynthesizer()) == null) {
					System.out.println("getSynthesizer() failed!");
					return;
				}
			}
			synthesizer.open();
			sequencer = MidiSystem.getSequencer();
			sequence = new Sequence(Sequence.PPQ, 10);
		} catch (Exception ex) {
			ex.printStackTrace();
			return;
		}

		Soundbank sb = synthesizer.getDefaultSoundbank();
		if (sb != null) {
			instruments = synthesizer.getDefaultSoundbank().getInstruments();
			synthesizer.loadInstrument(instruments[0]);
		}
		MidiChannel midiChannels[] = synthesizer.getChannels();

		channel_left = midiChannels[channel_index_left];
		channel_right = midiChannels[channel_index_right]; // ????channel

	}

	public static void nodeOn_left(int num) {
		num = num + flat;
		nodeOn(device_left, channel_index_left, num, velocity_left);

	}

	public static void nodeOn_right(int num) {
		num = num + flat;
		nodeOn(device_right, channel_index_right, num, velocity_right);

	}

	public static void nodeOff_left(int num) {
		num = num + flat;
		nodeOff(device_left, channel_index_left, num, velocity_left);
	}

	public static void nodeOff_right(int num) {
		num = num + flat;
		nodeOff(device_right, channel_index_right, num, velocity_right);
	}


	private static void nodeOn(MidiDevice midiDevice, int channel_index,
			int num, int pressure) {

		System.out.println("nodeOn" + num);
		ShortMessage message = new ShortMessage();
		try {
			message.setMessage(ShortMessage.NOTE_ON, channel_index, num,
					pressure);
			long timeStamp = -1;
			midiDevice.getReceiver().send(message, timeStamp);
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		} catch (InvalidMidiDataException e1) {
			e1.printStackTrace();
		}
	}

	private static void nodeOff(MidiDevice midiDevice, int channel_index,
			int num, int pressure) {
		System.out.println("nodeOff" + num);
		ShortMessage message = new ShortMessage();
		try {
			message.setMessage(ShortMessage.NOTE_OFF, channel_index, num,
					pressure);
			long timeStamp = -1;
			midiDevice.getReceiver().send(message, timeStamp);
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		} catch (InvalidMidiDataException e1) {
			e1.printStackTrace();
		}
	}

	public static void openDevice_left(String deviceName) {
		device_left = openDevice(deviceName);
	}

	public static void openDevice_right(String deviceName) {
		device_right = openDevice(deviceName);
	}

	public static MidiDevice openDevice(String deviceName) {

		MidiDevice.Info[] infos = MidiSystem.getMidiDeviceInfo();
		for (int i = 0; i < infos.length; i++) {
			MidiDevice.Info info = infos[i];
			String infoString = info.getName();

			System.out.println(infoString);

			if (infoString.startsWith(deviceName)) { // ????YAMAHA????????????

				MidiDevice device = null;
				try {
					device = MidiSystem.getMidiDevice(info);
				} catch (MidiUnavailableException e1) {
					e1.printStackTrace();
				}

				if (!device.isOpen()) {
					try {
						device.open();
					} catch (Exception e) { // ????????????(?????????,??MidiInDevice??MidiOutDevice????????????)
						// e.printStackTrace();
						continue;
					}

				}

				return device;
			}

		}

		return null;

	}

	public static void close() {
		if (device_left != null && device_left.isOpen()) {
			device_left.close();
		}
		if (device_right != null && device_right.isOpen()) {
			device_right.close();
		}

	}

	// ?????????????????
	public static void changeProgram_left(int program) {
		program_left = program;
		changeProgram(device_left, channel_index_left, program);

	}

	public static void changeProgram_right(int program) {
		program_right = program;
		changeProgram(device_right, channel_index_right, program);

	}

	public static void changeProgram_left2(int program) {
		program_left = program;
		changeProgram(device_left, channel_index_left, program);
	}

	public static void changeProgram_right2(int program) {
		program_right = program;
		changeProgram(device_right, channel_index_right, program);
	}

	// ????????
	private static void changeProgram(MidiDevice device, int channel_index,
			int program) {

		ShortMessage message = new ShortMessage();
		try {
			message.setMessage(ShortMessage.PROGRAM_CHANGE, channel_index,
					program, 127);
			long timeStamp = -1;
			device.getReceiver().send(message, timeStamp);

		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		} catch (InvalidMidiDataException e1) {
			e1.printStackTrace();
		}

	}

	public void play(int i, int s) {
		nodeOn_right(i);
		try {
			Thread.sleep(s);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		nodeOff_right(i);
	}

}
