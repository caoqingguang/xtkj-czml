package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ExpectedExceptionHelper;
import agi.foundation.compatibility.TestContextRule;
import cesiumlanguagewriter.*;
import java.io.StringWriter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;
import org.junit.Test;

@SuppressWarnings("unused")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCesiumStreamWriter {
    @Before
    public final void setUp() {
        m_stringWriter = new StringWriter();
        m_outputStream = new CesiumOutputStream(m_stringWriter);
        m_writer = new CesiumStreamWriter();
    }

    @Test
    public final void newPacketWritesObjectLiteral() {
        PacketCesiumWriter packet = m_writer.openPacket(m_outputStream);
        packet.close();
        Assert.assertEquals("{}", m_stringWriter.toString());
    }

    @Test
    public final void successiveCallsToNewPacketReturnSameInstance() {
        m_outputStream.writeStartSequence();
        PacketCesiumWriter packet1 = m_writer.openPacket(m_outputStream);
        packet1.close();
        PacketCesiumWriter packet2 = m_writer.openPacket(m_outputStream);
        packet2.close();
        m_outputStream.writeEndSequence();
        Assert.assertSame(packet1, packet2);
    }

    @Test
    public final void multipleCallsToNewPacketWithoutCloseThrowInvalidOperationException() {
        ExpectedExceptionHelper.expectException(getRule$expectedException(), IllegalStateException.class, "already opened", MessageMatch.CONTAINS);
        PacketCesiumWriter packet = m_writer.openPacket(m_outputStream);
        packet = m_writer.openPacket(m_outputStream);
    }

    private StringWriter m_stringWriter;
    private CesiumOutputStream m_outputStream;
    private CesiumStreamWriter m_writer;
    private TestContextRule rule$testContext = new TestContextRule();

    @Rule
    public TestContextRule getRule$testContext() {
        return rule$testContext;
    }

    private ExpectedException rule$expectedException = ExpectedException.none();

    @Rule
    public ExpectedException getRule$expectedException() {
        return rule$expectedException;
    }
}