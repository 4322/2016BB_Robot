package org.usfirst.frc.team4322.beachblitzrobot.subsystems;

import org.usfirst.frc.team4322.beachblitzrobot.vision.*;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Vision extends Subsystem
{
    private VisionThread thread;

    public void runThread()
    {
        if (thread != null)
            thread.die();
        thread = new VisionThread();
        thread.start();
    }

    public void stopThread()
    {
        if (thread != null)
            thread.die();
    }

    public VisionReport getVisionResults()
    {
        return thread.getResult();
    }

    @Override
    protected void initDefaultCommand()
    {
        // TODO Auto-generated method stub

    }

}
