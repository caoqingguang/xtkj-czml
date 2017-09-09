package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ArgumentException;
import agi.foundation.compatibility.AssertHelper;
import agi.foundation.compatibility.ExpectedExceptionHelper;
import agi.foundation.compatibility.TestContextRule;
import cesiumlanguagewriter.*;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;
import org.junit.Test;

@SuppressWarnings("unused")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestReference {
    @Test
    public final void canConstructEscapedReferences() {
        String value = "identifier#property";
        cesiumlanguagewriter.Reference reference = new Reference(value);
        Assert.assertEquals(reference.getIdentifier(), "identifier");
        final ArrayList<String> tempCollection$0 = new ArrayList<String>();
        tempCollection$0.add("property");
        AssertHelper.assertEquals(reference.getPropertyNames(), tempCollection$0);
        Assert.assertEquals(value, reference.getValue());
        value = "identifier#property.subProperty";
        reference = new Reference(value);
        Assert.assertEquals(reference.getIdentifier(), "identifier");
        final ArrayList<String> tempCollection$1 = new ArrayList<String>();
        tempCollection$1.add("property");
        tempCollection$1.add("subProperty");
        AssertHelper.assertEquals(reference.getPropertyNames(), tempCollection$1);
        Assert.assertEquals(value, reference.getValue());
        value = "\\#identif\\\\\\\\\\#ier\\.\\\\#propertyName.\\.abc\\\\.def";
        reference = new Reference(value);
        Assert.assertEquals(reference.getIdentifier(), "#identif\\\\#ier.\\");
        final ArrayList<String> tempCollection$2 = new ArrayList<String>();
        tempCollection$2.add("propertyName");
        tempCollection$2.add(".abc\\");
        tempCollection$2.add("def");
        AssertHelper.assertEquals(reference.getPropertyNames(), tempCollection$2);
        Assert.assertEquals(value, reference.getValue());
        value = "#propertyName.\\.abc\\\\.def";
        reference = new Reference(value);
        AssertHelper.assertIsEmpty(reference.getIdentifier());
        final ArrayList<String> tempCollection$3 = new ArrayList<String>();
        tempCollection$3.add("propertyName");
        tempCollection$3.add(".abc\\");
        tempCollection$3.add("def");
        AssertHelper.assertEquals(reference.getPropertyNames(), tempCollection$3);
        Assert.assertEquals(value, reference.getValue());
    }

    @Test
    public final void canConstructFromIdentifierAndProperty() {
        cesiumlanguagewriter.Reference reference = new Reference("identifier", "property");
        Assert.assertEquals(reference.getIdentifier(), "identifier");
        final ArrayList<String> tempCollection$4 = new ArrayList<String>();
        tempCollection$4.add("property");
        AssertHelper.assertEquals(reference.getPropertyNames(), tempCollection$4);
        Assert.assertEquals(reference.getValue(), "identifier#property");
        reference = new Reference("#identif\\\\#ier.\\", "property.Name");
        Assert.assertEquals(reference.getIdentifier(), "#identif\\\\#ier.\\");
        final ArrayList<String> tempCollection$5 = new ArrayList<String>();
        tempCollection$5.add("property.Name");
        AssertHelper.assertEquals(reference.getPropertyNames(), tempCollection$5);
        Assert.assertEquals(reference.getValue(), "\\#identif\\\\\\\\\\#ier\\.\\\\#property\\.Name");
    }

    @Test
    public final void canConstructFromIdentifierAndProperties() {
        final ArrayList<String> tempCollection$6 = new ArrayList<String>();
        tempCollection$6.add("property");
        tempCollection$6.add("subProperty");
        cesiumlanguagewriter.Reference reference = new Reference("identifier", tempCollection$6);
        Assert.assertEquals(reference.getIdentifier(), "identifier");
        final ArrayList<String> tempCollection$7 = new ArrayList<String>();
        tempCollection$7.add("property");
        tempCollection$7.add("subProperty");
        AssertHelper.assertEquals(reference.getPropertyNames(), tempCollection$7);
        Assert.assertEquals(reference.getValue(), "identifier#property.subProperty");
        final ArrayList<String> tempCollection$8 = new ArrayList<String>();
        tempCollection$8.add("property.Name");
        tempCollection$8.add("subProperty");
        reference = new Reference("#identif\\\\#ier.\\", tempCollection$8);
        Assert.assertEquals(reference.getIdentifier(), "#identif\\\\#ier.\\");
        final ArrayList<String> tempCollection$9 = new ArrayList<String>();
        tempCollection$9.add("property.Name");
        tempCollection$9.add("subProperty");
        AssertHelper.assertEquals(reference.getPropertyNames(), tempCollection$9);
        Assert.assertEquals(reference.getValue(), "\\#identif\\\\\\\\\\#ier\\.\\\\#property\\.Name.subProperty");
    }

    @Test
    public final void throwsWithMissingDelimiter() {
        ExpectedExceptionHelper.expectException(getRule$expectedException(), ArgumentException.class);
        new Reference("MissingDelimiter");
    }

    @Test
    public final void throwsWithMissingDelimiterDoToEscaping() {
        ExpectedExceptionHelper.expectException(getRule$expectedException(), ArgumentException.class);
        new Reference("Missing\\#Delimiter");
    }

    @Test
    public final void throwsWithMissingProperties() {
        ExpectedExceptionHelper.expectException(getRule$expectedException(), ArgumentException.class);
        new Reference("MissingPropertyName#");
    }

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