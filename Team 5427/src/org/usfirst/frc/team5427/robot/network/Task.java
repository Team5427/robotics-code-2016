package org.usfirst.frc.team5427.robot.network;

import java.io.Serializable;

public class Task implements Serializable {

	TaskDescription t;
	Object o;

	public Task(TaskDescription t) {
		this.t = t;
	}

	public Task(TaskDescription t, Object o) {
		this.t = t;
		this.o = o;
	}

	public TaskDescription getTask() {
		return t;
	}

	public Object getObject() {
		return o;
	}

}
